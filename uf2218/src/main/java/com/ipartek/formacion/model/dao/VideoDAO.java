package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Categoria;
import com.ipartek.formacion.model.pojo.Usuario;
import com.ipartek.formacion.model.pojo.Video;

public class VideoDAO {

	private static VideoDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT v.id as 'video_id', v.nombre as 'video_nombre', v.codigo as 'codigo', u.id as 'usuario_id', u.nombre as 'usuario_nombre', c.id as 'categoria_id', c.nombre as 'categoria_nombre' FROM video v, usuario u, categoria c WHERE v.usuario_id = u.id AND v.categoria_id = c.id ORDER BY v.id DESC LIMIT 500";
	private static final String SQL_GET_ALL_VISIBLE = "SELECT v.id as 'video_id', v.nombre as 'video_nombre', v.codigo as 'codigo', u.id as 'usuario_id', u.nombre as 'usuario_nombre', c.id as 'categoria_id', c.nombre as 'categoria_nombre' FROM video v, usuario u, categoria c WHERE v.usuario_id = u.id AND v.categoria_id = c.id AND u.fecha_eliminacion is NULL ORDER BY v.id DESC LIMIT 500";
	private static final String SQL_GET_ALL_NO_VISIBLE = "SELECT v.id as 'video_id', v.nombre as 'video_nombre', v.codigo as 'codigo', u.id as 'usuario_id', u.nombre as 'usuario_nombre', c.id as 'categoria_id', c.nombre as 'categoria_nombre' FROM video v, usuario u, categoria c WHERE v.usuario_id = u.id AND v.categoria_id = c.id AND u.fecha_eliminacion is not NULL ORDER BY v.id DESC LIMIT 500";
	private static final String SQL_GET_BY_ID = "SELECT v.id as 'video_id', v.nombre as 'video_nombre', v.codigo as 'codigo', u.id as 'usuario_id', u.nombre as 'usuario_nombre', c.id as 'categoria_id', c.nombre as 'categoria_nombre' FROM video v, usuario u, categoria c WHERE v.usuario_id = u.id AND v.categoria_id = c.id AND v.id = ?";
	private static final String SQL_UPDATE = "UPDATE video SET `nombre`= ?, `codigo`= ? , `usuario_id`= ? , `categoria_id`= ? WHERE `id` = ?;";
	private static final String SQL_INSERT = "INSERT INTO video (nombre, codigo,usuario_id,categoria_id) VALUES (?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM video WHERE id = ?";
	private static String sql="";
	
	
	
	private VideoDAO() {
		super();
	}

	public static synchronized VideoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	public ArrayList<Video> getAll() {

		ArrayList<Video> lista = new ArrayList<Video>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
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

	
	
	public ArrayList<Video> getAllVisible(Boolean isVisible) {

		ArrayList<Video> lista = new ArrayList<Video>();

		if(isVisible){
			 sql = SQL_GET_ALL_VISIBLE;
		}else {
			 sql = SQL_GET_ALL_NO_VISIBLE;
		}
		
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

	public boolean modificar(Video pojo, int usuarioId, int categoriaId) throws Exception {
		boolean resultado = false;


		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, usuarioId);
			pst.setInt(4, categoriaId);
			pst.setInt(5, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	public boolean crear(Video pojo, int usuarioId, int categoriId) throws Exception {
		boolean resultado = false;

		

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, usuarioId);
			pst.setInt(4, categoriId);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				//Conseguir ID generado de forma automatica
					try(ResultSet rsKeys = pst.getGeneratedKeys()){
						if(rsKeys.next()) {
							pojo.setId(rsKeys.getInt(1));
							resultado = true;
						}
					}
				
				
			}

			
			
		}

		return resultado;
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

	public Video mapper(ResultSet rs) throws SQLException {
		Video v = new Video();
		v.setId(rs.getInt("video_id"));
		v.setNombre(rs.getString("video_nombre"));
		v.setCodigo(rs.getString("codigo"));
	
		Usuario u = new Usuario();
		u.setId(rs.getInt("usuario_id"));
		u.setNombre(rs.getString("usuario_nombre"));
		v.setUsuario(u);
			
		Categoria c = new Categoria();
		c.setId(rs.getInt("categoria_id"));
		c.setNombre(rs.getString("categoria_nombre"));
		v.setCategoria(c);
		return v;
	}

}
