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

	private static final String SQL_GET_ALL = "SELECT u.id, u.nombre, r.id as id_rol, r.nombre as nombre_rol, contrasena, fecha_creacion, fecha_eliminacion FROM usuario as u, rol as r WHERE u.id_rol = r.id ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_ALL_REAL = "SELECT u.id, u.nombre, r.id as id_rol, r.nombre as nombre_rol, contrasena, fecha_creacion, fecha_eliminacion FROM usuario as u, rol as r WHERE u.id_rol = r.id AND u.fecha_eliminacion is Null ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_ALL_DELETED = "SELECT u.id, u.nombre, r.id as id_rol, r.nombre as nombre_rol, contrasena, fecha_creacion, fecha_eliminacion FROM usuario as u WHERE u.id_rol = r.id AND u.fecha_eliminacion is not Null ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT u.id, u.nombre, r.id as id_rol, r.nombre as nombre_rol, contrasena, fecha_creacion, fecha_eliminacion  FROM usuario as u, rol as r WHERE u.id_rol = r.id AND u.id = ? ;";
	private static final String SQL_GET_ALL_BY_NAME = "SELECT u.id, u.nombre, r.id as id_rol, r.nombre as nombre_rol, contrasena,id_rol, fecha_creacion, fecha_eliminacion FROM usuario as u, rol as r WHERE u.id_rol = r.id AND u.nombre LIKE ? ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO usuario (nombre, contrasena,id_rol) VALUES (?,?,?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, contrasena = ?, id_rol = ? WHERE  id = ?;";
	private static final String SQL_DELETE_LOGICO = "UPDATE usuario SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE  id = ?;";
	private static final String SQL_EXISTE = " SELECT u.id, u.nombre, r.id as id_rol, r.nombre as nombre_rol, contrasena, fecha_creacion, fecha_eliminacion FROM usuario as u, rol as r WHERE u.id_rol = r.id AND u.nombre = ? AND contrasena = ? AND fecha_eliminacion is null ;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private static String SQL = "";
	
	Rol rol = new Rol();
	
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
			// Sustituir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasena);

			// ejecutar secuencia SQL y obtener Resultado
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					usuario = mapper(rs);
				}

			} catch (Exception e) {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> listaUser = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				listaUser.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaUser;
	}
	
	/**
	 * Listado de usuarios logeados o eliminados en la bbdd
	 <b> Visible: </b> son los usuarios tenga fecha_eliminacion == null </br>
	 * <b> No Visible: </b> son los usuarios tenga fecha_eliminacion != null </br> 
	 * @param isVisible
	 * @return
	 */
	public ArrayList<Usuario> getAllVisible(boolean isVisible) {

		ArrayList<Usuario> listaUser = new ArrayList<Usuario>();
		
		SQL = SQL_GET_ALL_REAL;
		if(! isVisible) {
			SQL = SQL_GET_ALL_DELETED;
		}

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				listaUser.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaUser;
	}

	public ArrayList<Usuario> getAllByName(String nombre) {
		ArrayList<Usuario> listaUser = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_NAME);) {
			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					listaUser.add(mapper(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUser;
	}

	public Usuario getById(int id) {
		Usuario resul = new Usuario();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

			// sustituyo la 1º ? por la variable id
			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					/*
					 * Usuario u = new Usuario(); u.setId( rs.getInt("id") ); u.setNombre(
					 * rs.getString("nombre")); u.setCodigo( rs.getString("contrasena"));
					 */
					resul = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	public boolean modificar(Usuario pojo, int idRol) throws Exception {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasena());
			pst.setInt(3, idRol);
			pst.setInt(4, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	public Usuario crear(Usuario pojo, int idRol) throws Exception {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasena());
			pst.setInt(3, idRol);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguimos el id que acabamos de crear
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
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_LOGICO);) {
			
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

	/**
	 * Convierte un resultado de una BD a un pojo
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasena(rs.getString("contrasena"));
		u.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
		u.setFechaEliminacion(rs.getTimestamp("fecha_eliminacion"));
		
		Rol r = new Rol();
		r.setId(rs.getInt("id_rol"));
		r.setNombre(rs.getNString("nombre_rol"));
		
		u.setRol(r);
		
		return u;
	}

}
