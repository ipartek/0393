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

	private static final String SQL_GET_ALL = "SELECT v.id as video_id, v.nombre as video_nombre, v.codigo as codigo," + 
			" u.id as usuario_id, u.nombre as usuario_nombre, u.fecha_creacion as usuario_creacion, u.fecha_eliminacion as usuario_eliminacion," + 
			" c.id as categoria_id, c.nombre as categoria_nombre, COUNT(l.id_video) as megusta" + 
			" FROM video as v" + 
			" INNER JOIN usuario as u ON v.usuario_id = u.id " + 
			" INNER JOIN categoria as c ON v.categoria_id = c.id" + 
			" LEFT JOIN likes as l ON v.id = l.id_video" + 
			" GROUP BY v.id LIMIT 500;";


	private static final String SQL_GET_ALL_VIDEOS_NO_VISIBLES = "SELECT v.id as video_id, v.nombre as video_nombre, v.codigo as codigo," + 
			" u.id as usuario_id, u.nombre as usuario_nombre, u.fecha_creacion as usuario_creacion, u.fecha_eliminacion as usuario_eliminacion," + 
			" c.id as categoria_id, c.nombre as categoria_nombre, COUNT(l.id_video) as megusta" + 
			" FROM video as v" + 
			" INNER JOIN usuario as u ON v.usuario_id = u.id " + 
			" INNER JOIN categoria as c ON v.categoria_id = c.id" + 
			" LEFT JOIN likes as l ON v.id = l.id_video" + 
			" WHERE u.fecha_eliminacion IS NOT NULL" +
			" GROUP BY v.id LIMIT 500;";


	private static final String SQL_GET_ALL_VIDEOS_VISIBLES = "SELECT v.id as video_id, v.nombre as video_nombre, v.codigo as codigo," + 
			" u.id as usuario_id, u.nombre as usuario_nombre, u.fecha_creacion as usuario_creacion, u.fecha_eliminacion as usuario_eliminacion," + 
			" c.id as categoria_id, c.nombre as categoria_nombre, COUNT(l.id_video) as megusta" + 
			" FROM video as v" + 
			" INNER JOIN usuario as u ON v.usuario_id = u.id " + 
			" INNER JOIN categoria as c ON v.categoria_id = c.id" + 
			" LEFT JOIN likes as l ON v.id = l.id_video" + 
			" WHERE u.fecha_eliminacion IS NULL" +
			" GROUP BY v.id LIMIT 500;";
			
	//TODO revisar video detalle likes / debe ser un left join
	private static final String SQL_GET_BY_ID = "SELECT v.id as video_id, v.nombre as video_nombre, v.codigo as codigo," + 
			" u.id as usuario_id, u.nombre as usuario_nombre, u.fecha_creacion as usuario_creacion, u.fecha_eliminacion as usuario_eliminacion," + 
			" c.id as categoria_id, c.nombre as categoria_nombre, COUNT(l.id_video) as megusta" + 
			" FROM video as v" + 
			" INNER JOIN usuario as u ON v.usuario_id = u.id " + 
			" INNER JOIN categoria as c ON v.categoria_id = c.id" + 
			" LEFT JOIN likes as l ON v.id = l.id_video" + 
			" WHERE v.id = ?;";

	private static final String SQL_UPDATE = "UPDATE video SET nombre = ?," + " codigo = ?," + " categoria_id = ?,"
			+ " usuario_id= ?" + " WHERE  id = ?;";

	private static final String SQL_CREATE = "INSERT INTO video (nombre, codigo, categoria_id, usuario_id)"
			+ " VALUES (?,?,?,?);";

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

	/**
	 * Devuelve los videos dependiendo si son videos de usuarios activos o
	 * eliminados Para saber si un usuario esta eliminado debe tener
	 * fecha_eliminacion en la BD Si son usuarios activos su fecha_eliminacion es
	 * null
	 * 
	 * @param visible true - > su fecha eliminacion es null / false -> su
	 *                fecha_eliminacion no es null
	 * @return ArrayList<video>
	 */
	public ArrayList<Video> getAllVisible(boolean visible) {

		ArrayList<Video> lista = new ArrayList<Video>();

		String sql = "";

		if (visible) {
			sql = SQL_GET_ALL_VIDEOS_VISIBLES;
		} else {
			sql = SQL_GET_ALL_VIDEOS_NO_VISIBLES;
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

	/*
	 * 
	 * public ArrayList<Rol> getByName(String search) {
	 * 
	 * ArrayList<Rol> lista = new ArrayList<Rol>(); String sql =
	 * "SELECT id, nombre FROM rol WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500;";
	 * 
	 * try (Connection con = ConnectionManager.getConnection(); PreparedStatement
	 * pst = con.prepareStatement(sql)) { pst.setString(1, "%" + search + "%"); try
	 * (ResultSet rs = pst.executeQuery()) { while (rs.next()) {
	 * lista.add(mapper(rs)); } } } catch (Exception e) { e.printStackTrace(); }
	 * return lista; }
	 * 
	 * @Override public boolean save(Rol pojo) throws SQLException { boolean
	 * resultado = false;
	 * 
	 * if (pojo != null) { // Sanitize nombre
	 * pojo.setNombre(Utilidades.limpiarEspacios(pojo.getNombre()));
	 * 
	 * if (pojo.getId() == -1) { resultado = crear(pojo); } else { resultado =
	 * modificar(pojo); } }
	 * 
	 * return resultado; }
	 * 
	 */

	public boolean modificar(Video pojo) throws Exception {

		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, pojo.getCategoria().getId());
			pst.setInt(4, pojo.getUsuario().getId());
			pst.setInt(5, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	// Mejor pasar como parametro, video, int categoria.id, int usuario.id por que
	// se entienda mejor
	public Video crear(Video pojo) throws Exception { // TODO insertar categoria_id, usuario_id

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, pojo.getCategoria().getId());
			pst.setInt(4, pojo.getUsuario().getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				ResultSet rs = pst.getGeneratedKeys();

				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}
			}

		}

		return pojo;
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

	public Video mapper(ResultSet rs) throws SQLException {
		
		Video v = new Video();
		v.setId(rs.getInt("video_id"));
		v.setNombre(rs.getString("video_nombre"));
		v.setCodigo(rs.getString("codigo"));
		v.setLikes(rs.getInt("megusta"));

		Usuario u = new Usuario();
		u.setId(rs.getInt("usuario_id"));
		u.setNombre(rs.getString("usuario_nombre"));
		u.setFechaCreacion(rs.getTimestamp("usuario_creacion"));
		u.setFechaEliminacion(rs.getTimestamp("usuario_eliminacion"));

		Categoria c = new Categoria();
		c.setId(rs.getInt("categoria_id"));
		c.setNombre(rs.getString("categoria_nombre"));

		v.setUsuario(u);
		v.setCategoria(c);
		return v;

		
	}

}
