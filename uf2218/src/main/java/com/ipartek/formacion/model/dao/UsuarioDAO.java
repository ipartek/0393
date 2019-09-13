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

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

	/**
	 * Comprueba si existe el usuario en la base de datos, lo busca por su nombre y
	 * su contraseña y comprueba que no este eliminado (fecha_eliminacion IS NULL)
	 * 
	 * @param nombre
	 * @param contrasenya
	 * @return Usuario con datos si existe, null en caso de no existir
	 */

	public Usuario login(String nombre, String contrasenya) {

		Usuario usuario = null;

		String sql = "SELECT * FROM usuario WHERE nombre = ? AND contrasenya = ? AND fecha_eliminacion IS NULL;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			// Sustituimos ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasenya);

			// Ejecutamos la sentencia SQL y obtenemos el resultado
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
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
		String sql = "SELECT * FROM usuario ORDER BY id DESC LIMIT 500";

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

	/**
	 * Metodo que devuelve la lista de usuarios activos y usuarios elimiandos
	 * 
	 * @param isVisible boolean que determina si se obtienen los usuarios activos o
	 *                  los usuarios eliminados
	 * 
	 * @return lista de usuarios activos o eliminados
	 */

	public ArrayList<Usuario> getAllVisible(boolean isVisible) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "";

		if (isVisible) {
			sql = "SELECT * FROM usuario WHERE fecha_eliminacion IS NULL ORDER BY id DESC LIMIT 500";
		} else {
			sql = "SELECT * FROM usuario WHERE fecha_eliminacion IS NOT NULL ORDER BY id DESC LIMIT 500";
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

	public boolean crear(Usuario pojo) throws SQLException {
		boolean resultado = false;
		String sql = "INSERT INTO usuario (nombre, contrasenya, id_rol) VALUES (?,?,?);";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());
			pst.setInt(3, pojo.getIdRol());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}
		}

		return resultado;
	}

	public Usuario getById(int id) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE id = ? ;";

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

	public ArrayList<Usuario> getByName(String nombre) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE nombre LIKE '%" + nombre + "%';";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				usuario = mapper(rs);
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public boolean modificar(Usuario pojo) throws SQLException {
		boolean resultado = false;

		String sql = "UPDATE usuario SET nombre = ?, contrasenya = ?, id_rol = ?  WHERE id = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());
			pst.setInt(3, pojo.getIdRol());
			pst.setInt(4, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean delete(int id) {
		boolean resultado = false;
		String sql = "UPDATE usuario SET fecha_eliminacion = CURRENT_TIMESTAMP WHERE id = ?;";

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

	private Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasenya(rs.getString("contrasenya"));
		u.setIdRol(rs.getInt("id_rol"));
		u.setfCreacion(rs.getTimestamp("fecha_creacion"));
		u.setfBaja(rs.getTimestamp("fecha_eliminacion"));
		return u;
	}
}