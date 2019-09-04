package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Usuario;
import com.ipartek.formacion.model.pojo.Youtube;

public class YoutubeDAO {

	private static YoutubeDAO INSTANCE = null;

	private YoutubeDAO() {
		super();
	}

	public static YoutubeDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new YoutubeDAO();
		}
		return INSTANCE;
	}

	public ArrayList<Youtube> getAll() {

		ArrayList<Youtube> lista = new ArrayList<Youtube>();
		String sql = "SELECT `id`, `nombre`, `codigo` FROM `video` ORDER BY `id` DESC LIMIT 500";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				/*
				 * Youtube v = new Youtube(); v.setId( rs.getInt("id") ); v.setNombre(
				 * rs.getString("nombre")); v.setCodigo( rs.getString("codigo"));
				 */
				lista.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	public Youtube getById(int id) {
		Youtube video = new Youtube();
		String sql = "SELECT id, nombre, codigo FROM video WHERE id = ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			// sustituyo la 1º ? por la variable id
			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					/*
					 * Youtube v = new Youtube(); v.setId( rs.getInt("id") ); v.setNombre(
					 * rs.getString("nombre")); v.setCodigo( rs.getString("codigo"));
					 */
					video = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return video;
	}

	/*
	 * public ArrayList<Rol> getByName(String search) { ArrayList<Rol> lista = new
	 * ArrayList<Rol>(); String sql =
	 * "SELECT id, nombre FROM rol WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500;";
	 * try (Connection con = ConnectionManager.getConnection(); PreparedStatement
	 * pst = con.prepareStatement(sql)) { pst.setString(1, "%" + search + "%"); try
	 * (ResultSet rs = pst.executeQuery()) { while (rs.next()) {
	 * lista.add(mapper(rs)); } } } catch (Exception e) { e.printStackTrace(); }
	 * return lista; }
	 * 
	 * @Override public boolean save(Rol pojo) throws SQLException { boolean
	 * resultado = false; if (pojo != null) { // Sanitize nombre
	 * pojo.setNombre(Utilidades.limpiarEspacios(pojo.getNombre())); if
	 * (pojo.getId() == -1) { resultado = crear(pojo); } else { resultado =
	 * modificar(pojo); } } return resultado; }
	 */
	public boolean modificar(Youtube pojo, HttpSession session) throws Exception {
		boolean resultado = false;

		String sql = "UPDATE video SET nombre = ?, codigo = ?, id_usuario = ? WHERE  id = ?;";

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, usuario.getId());
			pst.setInt(4, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean crear(Youtube pojo, HttpSession session) throws Exception {
		boolean resultado = false;
		String sql = "INSERT INTO video (nombre, codigo, id_usuario) VALUES (?,?,?);";

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, usuario.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	/*
	 * private boolean doSave(PreparedStatement pst, Rol pojo) throws
	 * MySQLIntegrityConstraintViolationException, MysqlDataTruncation { boolean
	 * resultado = false; try { int affectedRows = pst.executeUpdate(); if
	 * (affectedRows == 1) { try (ResultSet generatedKeys = pst.getGeneratedKeys())
	 * { if (generatedKeys.next()) { pojo.setId(generatedKeys.getInt(1)); } }
	 * resultado = true; } } catch (MySQLIntegrityConstraintViolationException e) {
	 * System.out.println("Rol duplicado"); throw e; } catch (MysqlDataTruncation e)
	 * { System.out.println("Nombre muy largo"); throw e; } catch (Exception e) {
	 * e.printStackTrace(); } return resultado; }
	 * 
	 * @Override
	 */
	public boolean eliminar(int id) {
		boolean resultado = false;
		String sql = "DELETE FROM video WHERE id = ?;";

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

	public Youtube mapper(ResultSet rs) throws SQLException {
		Youtube video = new Youtube();
		video.setId(rs.getInt("id"));
		video.setNombre(rs.getString("nombre"));
		video.setCodigo(rs.getString("codigo"));
		return video;
	}

}