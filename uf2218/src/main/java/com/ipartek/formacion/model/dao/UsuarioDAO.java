package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;
	private static String SQL_VER_USUARIOS_VISIBLES = "SELECT id, nombre, contrasenya, id_rol as 'rol', fecha_creacion, fecha_eliminacion FROM usuario WHERE fecha_eliminacion is null  ORDER BY id ASC LIMIT 500";
	private static String SQL_VER_USUARIOS_NO_VISIBLES = "SELECT id, nombre, contrasenya, id_rol as 'rol', fecha_creacion, fecha_eliminacion FROM usuario WHERE fecha_eliminacion is not null  ORDER BY id ASC LIMIT 500";
	private static String SQL_USUARIO_EXISTE = "SELECT u.id, u.nombre, u.contrasenya, r.id AS 'rol', u.fecha_creacion, u.fecha_eliminacion FROM usuario AS u, rol AS r WHERE u.id_rol=r.id AND u.nombre = ? AND u.contrasenya = ? ;";
	private static String SQL_GET_ALL_USERS = "SELECT `id`, `nombre`, `contrasenya`, id_rol AS 'rol', fecha_creacion, fecha_eliminacion FROM `usuario` ORDER BY `id` ASC LIMIT 500";
	private static String SQL_GET_ALL_USERS_BY_NAME = "SELECT id, nombre, contrasenya,id_rol AS 'rol', fecha_creacion, fecha_eliminacion FROM usuario WHERE nombre LIKE ? ORDER BY id ASC LIMIT 500";
	private static String SQL_GET_USER_BY_ID = "SELECT id, nombre, contrasenya, id_rol AS 'rol', fecha_creacion, fecha_eliminacion FROM usuario WHERE id = ? ;";
	private static String SQL_UPDATE_USER = "UPDATE usuario SET nombre = ?, contrasenya = ? WHERE  id = ?;";
	private static String SQL_INSERT_USER = "INSERT INTO usuario (nombre, contrasenya) VALUES (?,?);";
	// private static String SQL_DELETE_USER = "DELETE FROM usuario WHERE id = ?;";
	private static String SQL_DELETE_USER = "UPDATE usuario SET fecha_eliminacion = current_timestamp() WHERE  id = ?;";

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
	 * Compruaba si existe el usuario en la base datos, lo busca por su nombre y
	 * conetrasenya
	 * 
	 * @param nombre
	 * @param contrasenya
	 * @return Usuario con datos si existe, null en caso de no existir
	 */
	public Usuario existe(String nombre, String contrasenya) {

		Usuario usuario = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_USUARIO_EXISTE);) {

			// sustituir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasenya);

			// ejecutar sentencia SQL y obtener Resultado
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasenya(rs.getString("contrasenya"));
					usuario.setRol(rs.getInt("rol"));
					usuario.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
					usuario.setFechaEliminacion(rs.getTimestamp("fecha_eliminacion"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public ArrayList<Usuario> getAllVisible(boolean isVisible) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		String sql = SQL_VER_USUARIOS_VISIBLES;
		if (!isVisible) {
			sql = SQL_VER_USUARIOS_NO_VISIBLES;
		}

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				lista.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_USERS);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				lista.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Usuario> getAllByName(String nombre) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_USERS_BY_NAME);) {

			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					lista.add(mapper(rs));
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasenya(rs.getString("contrasenya"));
		u.setRol(rs.getInt("rol"));
		u.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
		u.setFechaEliminacion(rs.getTimestamp("fecha_eliminacion"));
		return u;
	}

	public Usuario getById(int id) {
		Usuario usuario = new Usuario();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_USER_BY_ID)) {

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

	public boolean modificar(Usuario pojo) throws Exception {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE_USER)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());
			pst.setInt(3, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	public Usuario crear(Usuario pojo) throws Exception {
		// boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}
				// resultado = true;
			}

		}

		return pojo;
	}

	public boolean delete(int id) {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_USER);) {

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
}
