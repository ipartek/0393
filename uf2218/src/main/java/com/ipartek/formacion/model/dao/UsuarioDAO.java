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

	private static final String SQL_GET_ALL = "SELECT `id`, `nombre`, `contrasena` FROM `usuario` ORDER BY `id` LIMIT 500;";

	private static final String SQL_GET_ALL_NAME = "SELECT id, nombre, contrasena FROM usuario WHERE nombre LIKE ? ORDER BY nombre ASC LIMIT 500;";

	private static final String SQL_NEW_USER = "INSERT INTO usuario (nombre, contrasena) VALUES (?,?);";

	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";

	private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, contrasena = ? WHERE id = ?; ";

	// TODO usar constante para getById

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

		String sql = " SELECT id, nombre, contrasena " + " FROM usuario " + " WHERE nombre = ? AND contrasena = ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

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

	public Usuario getById(int id) {
		Usuario usuario = new Usuario();
		String sql = "SELECT `id`, `nombre`, `contrasena`  FROM usuario WHERE id = ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

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

	public Usuario create(Usuario usuario) { // TODO revisar

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

	private Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasena(rs.getString("contrasena"));
		return u;
	}

}
