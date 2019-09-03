package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;

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
	 * @param contrasenya
	 * @return Usuario con datos si existe, null en caso de no existir
	 */
	public Usuario existe(String nombre, String contrasenya) {

		Usuario usuario = null;

		String sql = " SELECT id, nombre, contrasenya " + " FROM usuario " + " WHERE nombre = ? AND contrasenya = ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

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
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT `id`, `nombre`, `contrasenya` FROM `usuario` ORDER BY `id` ASC LIMIT 500";

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

	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasenya(rs.getString("contrasenya"));
		return u;
	}

	public Usuario getById(int id) {
		Usuario usuario = new Usuario();
		String sql = "SELECT id, nombre, contrasenya FROM usuario WHERE id = ? ;";

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

	public boolean modificar(Usuario pojo) throws Exception {
		boolean resultado = false;

		String sql = "UPDATE usuario SET nombre = ?, contrasenya = ? WHERE  id = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

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

	public boolean crear(Usuario pojo) throws Exception {
		boolean resultado = false;
		String sql = "INSERT INTO usuario (nombre, contrasenya) VALUES (?,?);";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}

		return resultado;
	}

	public boolean delete(int id) {
		boolean resultado = false;
		String sql = "DELETE FROM usuario WHERE id = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

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
