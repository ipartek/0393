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

	private static final String SQL_GET_ALL = "SELECT idusuario,nombre,contra FROM usuario ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT idusuario,nombre,contra FROM usuario WHERE id = ?;";
	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT idusuario,nombre,contra FROM usuario WHERE nombre LIKE ? ORDER BY nombre ASC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO usuario ( nombre, contra) VALUES ( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ?, contra= ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() { // syncronized para que varias ejecuciones no se ejecuten a la
															// vez

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();

		}
		return INSTANCE;
	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String sql = "SELECT `idusuario`, `nombre`, `contra` FROM `usuario`";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				/*
				 * Video v = new Video(); v.setId( rs.getInt("id") ); v.setNombre(
				 * rs.getString("nombre")); v.setCodigo( rs.getString("codigo"));
				 */
				listaUsuarios.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaUsuarios;
	}

	// metodo para comprobar si un usuario existe
	public Usuario existe(String nombre, String contra) {

		Usuario usuario = null;

		String sql = "SELECT idusuario, nombre, contra " + " FROM videos_manuel.usuario "
				+ " where nombre = ? and contra = ?";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			// sustituir ? por parámetros
			pst.setString(1, nombre);
			pst.setString(2, contra);

			// ejecutar sql y obtener resultado

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {

					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContra(rs.getString("contra"));
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
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

	public boolean crear(Usuario pojo) throws Exception {
		boolean resultado = false;
		String sql = "INSERT INTO usuario (nombre, contra) VALUES (?,?);";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContra());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}

		return resultado;
	}

	public boolean modificar(Usuario pojo) throws Exception {
		boolean resultado = false;

		String sql = "UPDATE usuario SET nombre = ?, contra = ? WHERE  id = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContra());
			pst.setInt(3, pojo.getId());

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

	/**
	 * Convierte un resultado de la BD a un POJO
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario us = new Usuario();
		us.setId(rs.getInt("id"));
		us.setNombre(rs.getString("nombre"));
		us.setContra(rs.getString("contra"));
		return us;
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
}
