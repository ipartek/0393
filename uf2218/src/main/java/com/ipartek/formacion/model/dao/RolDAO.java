package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Rol;
import com.ipartek.formacion.model.pojo.Video;
import com.mysql.jdbc.Statement;

public class RolDAO {

	private static RolDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT id,nombre FROM rol ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = " SELECT " + " v.idvideo as 'video_id', "
			+ " v.titulo as 'video_nombre', " + " codigo, " + " u.idusuario as 'usuario_id', "
			+ " u.nombre as 'usuario_nombre', " + " c.idcategoria as 'categoria_id', "
			+ " c.nombre as 'categoria_nombre' " + " FROM video as v, usuario as u , categoria as c "
			+ " WHERE v.usuario_idusuario = u.idusuario AND v.categoria_idcategoria = c.idcategoria AND v.idvideo = ? "
			+ " ORDER BY v.idvideo DESC LIMIT 500;";
	private static final String SQL_UPDATE = "UPDATE rol SET `mombre`= ? WHERE `id` = ?;";
	private static final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?);";

	private RolDAO() {
		super();
	}

	public static synchronized RolDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}

		return INSTANCE;

	}

	public ArrayList<Rol> getAll() {

		ArrayList<Rol> lista = new ArrayList<Rol>();

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

	private Rol mapper(ResultSet rs) throws SQLException {
		Rol r = new Rol();
		r.setId(rs.getInt("id"));
		r.setNombre(rs.getString("nombre"));
		return r;
	}

	public Video getById(int id) {
		Video video = new Video();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

			// sustituyo la 1º ? por la variable id
			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					/*
					 * Video v = new Video(); v.setId( rs.getInt("id") ); v.setNombre(
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

	public boolean modificar(Rol pojo, int usuarioId, int categoriaId) throws Exception {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	public boolean crear(Rol pojo) throws Exception {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguir id generado de forma automatica
				try (ResultSet rsKeys = pst.getGeneratedKeys()) {
					if (rsKeys.next()) {
						pojo.setId(rsKeys.getInt(1));
						resultado = true;
					}
				}
			}

		}

		return resultado;
	}

	/*
	 * 
	 * private boolean doSave(PreparedStatement pst, Rol pojo) throws
	 * MySQLIntegrityConstraintViolationException, MysqlDataTruncation { boolean
	 * resultado = false;
	 * 
	 * try { int affectedRows = pst.executeUpdate(); if (affectedRows == 1) { try
	 * (ResultSet generatedKeys = pst.getGeneratedKeys()) { if
	 * (generatedKeys.next()) { pojo.setId(generatedKeys.getInt(1)); } } resultado =
	 * true; } } catch (MySQLIntegrityConstraintViolationException e) {
	 * System.out.println("Rol duplicado"); throw e; } catch (MysqlDataTruncation e)
	 * { System.out.println("Nombre muy largo"); throw e; } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return resultado; }
	 */

	public boolean delete(int id) {
		boolean resultado = false;
		String sql = "DELETE FROM rol WHERE id = ?;";

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
