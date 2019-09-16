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
	private static final String SQL_GET_ALL = "SELECT u.id, u.nombre, u.contrasena, r.id AS 'id_rol', r.nombre AS 'nombre_rol', u.fecha_creacion, u.fecha_eliminacion FROM usuario AS u, rol AS r WHERE u.id_rol = r.id ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_ALL_VISIBLE = "SELECT u.id, u.nombre, u.contrasena, r.id AS 'id_rol', r.nombre AS 'nombre_rol', u.fecha_creacion, u.fecha_eliminacion FROM usuario AS u, rol AS r WHERE u.id_rol = r.id AND fecha_eliminacion is NULL ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_ALL_INVISIBLE = "SELECT u.id, u.nombre, u.contrasena, r.id AS 'id_rol', r.nombre AS 'nombre_rol', u.fecha_creacion, u.fecha_eliminacion FROM usuario AS u, rol AS r WHERE u.id_rol = r.id AND fecha_eliminacion is not NULL ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT u.id, u.nombre, u.contrasena, r.id AS 'id_rol', r.nombre AS 'nombre_rol', u.fecha_creacion, u.fecha_eliminacion FROM usuario AS u, rol AS r WHERE u.id_rol = r.id AND u.id = ?;";
	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT u.id, u.nombre, u.contrasena, r.id AS 'id_rol', r.nombre AS 'nombre_rol', u.fecha_creacion, u.fecha_eliminacion FROM usuario AS u, rol AS r WHERE u.id_rol = r.id AND u.nombre LIKE ? ORDER BY u.nombre ASC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO usuario ( nombre, contrasena) VALUES ( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ?, contrasena= ? WHERE id = ?;";
	//private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private static final String SQL_DELETE = "UPDATE usuario SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE (id = ?);";
	private static final String SQL_EXISTE = "SELECT u.id, u.nombre, u.contrasena, r.id AS 'id_rol', r.nombre AS 'nombre_rol', u.fecha_creacion, u.fecha_eliminacion FROM usuario AS u, rol AS r WHERE u.id_rol = r.id AND u.nombre = ? AND contrasena = ? ;"; 

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
	 * Compruab si existe el usuario en la base datos, lo busca por su nombre y
	 * conetrsenya
	 * 
	 * @param nombre
	 * @param contrasena
	 * @return Usuario con datos si existe, null en caso de no existir
	 */
	public Usuario existe(String nombre, String contrasena) {

		Usuario usuario = null;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(SQL_EXISTE);) {

			// sustituir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasena);

			// ejecutar sentencia SQL y obtener Resultado
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					usuario = new Usuario();
					usuario = mapper(rs);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				/*
				 * Usuario u = new Usuario(); u.setId(rs.getInt("id"));
				 * u.setNombre(rs.getString("nombre"));
				 * u.setcontrasena(rs.getString("contrasena")); lista.add(u);
				 */
				lista.add(mapper(rs));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public ArrayList<Usuario> getAllVisible(boolean isVisible) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		String sql = SQL_GET_ALL_VISIBLE;
		
		if (!isVisible) {
			sql = SQL_GET_ALL_INVISIBLE;
		}

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				/*
				 * Usuario u = new Usuario(); u.setId(rs.getInt("id"));
				 * u.setNombre(rs.getString("nombre"));
				 * u.setcontrasena(rs.getString("contrasena")); lista.add(u);
				 */
				lista.add(mapper(rs));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	
	
	

	public ArrayList<Usuario> getAllByNombre(String nombre) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_NOMBRE);) {

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

	public Usuario getById(int id) {
		Usuario resul = new Usuario();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					resul = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

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
			pst.setInt(3, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	public Usuario crear(Usuario pojo) throws Exception {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasena());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguimos el ID que acabamos de crear
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}

			}

		}

		return pojo;
	}

	private Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasena(rs.getString("contrasena"));
		
		u.setFechaEliminacion(rs.getTimestamp("fecha_eliminacion"));
		u.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
		
		Rol r = new Rol();
		r.setId(rs.getInt("id_rol"));
		r.setNombre(rs.getString("nombre_rol"));
		
		u.setRol(r);
		
		return u;
	}

}