package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Categoria;
import com.ipartek.formacion.model.pojo.Usuario;
import com.ipartek.formacion.model.pojo.Video;

public class VideoDAO {

	private static VideoDAO INSTANCE = null;

	private VideoDAO() {
		super();
	}

	public static VideoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	public ArrayList<Video> getAll() {

		ArrayList<Video> lista = new ArrayList<Video>();
		String sql = "SELECT v.id as 'id_video', " + "v.nombre as 'nombre_video', " + "v.codigo as 'codigo', "
				+ "u.id as 'id_usuario', " + "u.nombre as 'nombre_usuario', " + "c.id as 'id_categoria', "
				+ "c.nombre as 'nombre_categoria' " + "FROM " + "video as v, usuario as u, categoria as c " + "WHERE "
				+ "v.id_usuario = u.id AND v.id_categoria = c.id " + "ORDER BY 'id_video' DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				/*
				 * Video v = new Video(); v.setId( rs.getInt("id") ); v.setNombre(
				 * rs.getString("nombre")); v.setCodigo( rs.getString("codigo"));
				 */
				lista.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	public Video getById(int id) {
		Video video = new Video();
		String sql = "SELECT v.id as 'id_video', " + "v.nombre as 'nombre_video', " + "v.codigo as 'codigo', "
				+ "u.id as 'id_usuario', " + "u.nombre as 'nombre_usuario' " + "c.id as 'id_categoria', "
				+ "c.nombre as 'nombre_categoria' " + "FROM " + "video as v, usuario as u, categoria as c " + "WHERE "
				+ "v.id_usuario = u.id AND v.id_categoria = c.id AND v.id = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

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

	public boolean modificar(Video pojo) throws Exception {
		boolean resultado = false;

		String sql = "UPDATE video SET nombre = ?, codigo = ? WHERE  id = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean crear(Video pojo, int idUser) throws Exception {
		boolean resultado = false;
		String sql = "INSERT INTO video (nombre, codigo, id_usuario) VALUES (?,?,?);";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, idUser);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean delete(int id) {
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

	private Video mapper(ResultSet rs) throws SQLException {
		Video v = new Video();
		v.setId(rs.getInt("id_video"));
		v.setNombre(rs.getString("nombre_video"));
		v.setCodigo(rs.getString("codigo"));

		Usuario u = new Usuario();
		u.setId(rs.getInt("id_usuario"));
		u.setNombre(rs.getString("nombre_usuario"));

		Categoria c = new Categoria();
		c.setId(rs.getInt("id_categoria"));
		c.setNombre(rs.getString("nombre_categoria"));

		v.setUsuario(u);
		v.setCategoria(c);

		return v;
	}
}