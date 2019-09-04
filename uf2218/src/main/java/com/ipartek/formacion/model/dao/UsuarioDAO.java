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

	private static final String SQL_GET_ALL = "SELECT id,nombre,contrasena FROM usuario ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, contrasena  FROM usuario WHERE id = ? ;";
	private static final String SQL_GET_ALL_BY_NAME = "SELECT id,nombre, contrasena FROM usuario WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO usuario (nombre, contrasena) VALUES (?,?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, contrasena = ? WHERE  id = ?;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";

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

		String sql = " SELECT id, nombre, contrasena " + " FROM usuario " + " WHERE nombre = ? AND contrasena = ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			// Sustituir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasena);

			// ejecutar secuencia SQL y obtener Resultado
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {

					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasena(rs.getString("contrasena"));

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
		return u;
	}

}
