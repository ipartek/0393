package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Rol;
import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT u.id, u.nombre, u.contrasena, u.rol as rol_id, r.nombre as rol_nombre, u.fecha_creacion, u.fecha_eliminacion"
			+ " FROM usuario as u, rol as r" + " WHERE u.rol = r.id ORDER BY `id` LIMIT 500;";

	private static final String SQL_GET_ALL_ACTIVOS = "SELECT u.id, u.nombre, u.contrasena, u.rol as rol_id, r.nombre as rol_nombre, u.fecha_creacion, u.fecha_eliminacion"
			+ " FROM usuario as u, rol as r"
			+ " WHERE u.rol = r.id AND fecha_eliminacion IS NULL ORDER BY `id` LIMIT 500;";

	private static final String SQL_GET_ALL_ELIMINADOS = "SELECT u.id, u.nombre, u.contrasena, u.rol as rol_id, r.nombre as rol_nombre, u.fecha_creacion, u.fecha_eliminacion"
			+ " FROM usuario as u, rol as r"
			+ " WHERE u.rol = r.id AND fecha_eliminacion IS NOT NULL ORDER BY `id` LIMIT 500;";

	private static final String SQL_GET_ALL_NAME = "SELECT id, nombre, contrasena FROM usuario WHERE nombre LIKE ? ORDER BY nombre ASC LIMIT 500;";

	private static final String SQL_GET_BY_ID = "SELECT u.id, u.nombre, u.contrasena, u.rol as rol_id, r.nombre as rol_nombre, u.fecha_creacion, u.fecha_eliminacion"
			+ " FROM usuario as u, rol as r" + " WHERE u.rol = r.id AND u.id = ?";

	private static final String SQL_NEW_USER = "INSERT INTO usuario (nombre, contrasena) VALUES (?,?);";

	private static final String SQL_DELETE = "UPDATE usuario SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE id = ?; ";

	// "DELETE FROM usuario WHERE id = ?;"; YA no se usara
	private static final String SQL_EXISTE = " SELECT id, nombre, contrasena" + " FROM usuario"
			+ " WHERE nombre = ? AND contrasena = ? AND fecha_eliminacion IS NULL ;";

	private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, contrasena = ?, rol = ? WHERE id = ?; ";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

	/**
	 * Comprueba si existe el usuario en la BD, lo busca por su nombre y contrasena
	 * 
	 * @param nombre
	 * @param contrasena
	 * @return Usuario con datos si existe, null en caso de no existir
	 */
	public Usuario existe(String nombre, String contrasena) {

		Usuario usuario = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);) {

			// sustituir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasena);

			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasena(rs.getString("contrasena"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	/**
	 * Devuelve todos los usuarios, tanto los activos, como los "eliminados"
	 * 
	 * @return
	 */
	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				lista.add(mapper(rs));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Devuelve una lista de usuarios en funcion de si tienen fecha_eliminacion
	 * establecida en la BD<br>
	 * Si fecha_eliminacion es null, son usuarios activos. Si la fecha_eliminacion
	 * esta establecida son usuarios inactivos
	 * 
	 * @param isVisible true -> fecha_eliminacion es null (Usuarios activos) / false
	 *                  -> fecha eliminacion != null (usuarios eliminados)
	 * @return ArrayList<Usuario> lista de usuarios activos o eliminados
	 */
	public ArrayList<Usuario> getAllVisible(boolean isVisible) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		String sql = SQL_GET_ALL_ELIMINADOS;

		if (isVisible) {
			sql = SQL_GET_ALL_ACTIVOS;
		}

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				lista.add(mapper(rs));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lista;
	}

	public Usuario getById(int id) {
		Usuario usuario = new Usuario();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

			// sustituyo la 1º ? por la variable id
			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {

					usuario = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public ArrayList<Usuario> getAllByName(String nombre) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_NAME);) {

			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					lista.add(mapper(rs));
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;

	}

	public Usuario create(Usuario usuario) {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_NEW_USER, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getContrasena());

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				// conseguimos el ID que acabamos de crear
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					usuario.setId(rs.getInt(1));

				}

			}

			/*
			 * ResultSet rs = pst.getGeneratedKeys(); // recupera key (id en este caso)
			 * generado por la BDD rs.next(); idGenerado = rs.getInt(1);
			 */

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return usuario;
	}

	/**
	 * Actualiza en la BD el registro estableciendo la fecha_eliminacion a la fecha
	 * en que se ejecuta la update<br>
	 * De esta forma con fecha_eliminacion sera "no visible" en getAllVisible()
	 * 
	 * @see UsuarioDAO.getAllVisible()
	 * @param id el identificador que sera actualizado
	 * @return
	 */
	public boolean delete(int id) {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				resultado = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean modificar(Usuario pojo) throws Exception {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasena());
			pst.setInt(3, pojo.getRol().getId());
			pst.setInt(4, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	private Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasena(rs.getString("contrasena"));

		Rol r = new Rol();
		r.setId(rs.getInt("rol_id"));
		r.setNombre(rs.getString("rol_nombre"));

		u.setRol(r);

		u.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
		u.setFechaEliminacion(rs.getTimestamp("fecha_eliminacion"));
		return u;
	}

	// TODO Los usuarios eliminados no pueden loguearse

	// TODO Detalle usuario, rol (poder cambiarlo), fecha_creacion,
	// fecha-eliminacion

	// TODO Al "eliminar" usuario, no debe hacer delete, si no ponerle una
	// fecha_eliminacion

}
