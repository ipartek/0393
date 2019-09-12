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
import com.mysql.jdbc.Statement;

public class VideoDAO {

	private static VideoDAO INSTANCE = null;
	
	private static final String SQL_GET_ALL =   " SELECT " + 
													" v.id as 'video_id', " + 
													" v.nombre as 'video_nombre', " + 
													" codigo, " + 
													" u.id as 'usuario_id', " +
													" u.nombre as 'usuario_nombre', " + 
													" c.id as 'categoria_id', " + 
													" c.nombre as 'categoria_nombre' " +													
												" FROM video as v, usuario as u , categoria as c " + 
												" WHERE v.id_usuario = u.id AND v.id_categoria = c.id " + 
												" ORDER BY v.id DESC LIMIT 500;";
	
	private static final String SQL_GET_ALL_VISIBLE =   " SELECT " + 
															" v.id as 'video_id', " + 
															" v.nombre as 'video_nombre', " + 
															" codigo, " + 
															" u.id as 'usuario_id', " +
															" u.nombre as 'usuario_nombre', " + 
															" c.id as 'categoria_id', " + 
															" c.nombre as 'categoria_nombre' " +													
														" FROM video as v, usuario as u , categoria as c " + 
														" WHERE v.id_usuario = u.id AND v.id_categoria = c.id AND u.fecha_eliminacion is NULL " + 
														" ORDER BY v.id DESC LIMIT 500;";
	
	private static final String SQL_GET_ALL_INVISIBLE =   " SELECT " + 
																" v.id as 'video_id', " + 
																" v.nombre as 'video_nombre', " + 
																" codigo, " + 
																" u.id as 'usuario_id', " +
																" u.nombre as 'usuario_nombre', " + 
																" c.id as 'categoria_id', " + 
																" c.nombre as 'categoria_nombre' " +													
															" FROM video as v, usuario as u , categoria as c " + 
															" WHERE v.id_usuario = u.id AND v.id_categoria = c.id AND u.fecha_eliminacion is not NULL " + 
															" ORDER BY v.id DESC LIMIT 500;";

	private static final String SQL_GET_BY_ID =   " SELECT " + 
													" v.id as 'video_id', " + 
													" v.nombre as 'video_nombre', " + 
													" codigo, " + 
													" u.id as 'usuario_id', " +
													" u.nombre as 'usuario_nombre', " + 
													" c.id as 'categoria_id', " + 
													" c.nombre as 'categoria_nombre' " +													
												" FROM video as v, usuario as u , categoria as c " + 
												" WHERE v.id_usuario = u.id AND v.id_categoria = c.id AND v.id = ? " + 
												" ORDER BY v.id DESC LIMIT 500;";
	
	private static final String SQL_INSERT = "INSERT INTO video (nombre, codigo, id_usuario, id_categoria) VALUES (?,?,?,?);";
	
	
	private static final String SQL_UPDATE = "UPDATE video SET `nombre`= ?, `codigo`= ? , `id_usuario`= ? , `id_categoria`= ? WHERE `id` = ?;";
	
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
				lista.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Saca un listado de los videos publicados o eliminados según el parámetro de búsqueda
	 * @param isVisible (boolean) TRUE si queremos los visibles, FALSE si queremos los invisibles.
	 * @return
	 */
	public ArrayList<Video> getAllVisible(boolean isVisible) {

		ArrayList<Video> lista = new ArrayList<Video>();
		
		String sql = SQL_GET_ALL_VISIBLE;
		
		if (isVisible) {
			sql = SQL_GET_ALL_INVISIBLE;	
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

	public Video getById(int id) {
		Video video = new Video();
		

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

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

	public boolean modificar(Video pojo, int usuarioId, int categoriaId) throws Exception {
		boolean resultado = false;

	

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

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

	public boolean crear(Video pojo, int idUsuario, int idCategoria) throws Exception {
		boolean resultado = false;
		/*String sql = "INSERT INTO video (nombre, codigo) VALUES (?,?);";*/
		


		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, idUsuario);
			pst.setInt(4, idCategoria);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				
				//Conseguir ID generado de forma automática.
				try (ResultSet rsKeys = pst.getGeneratedKeys();) {
					if(rsKeys.next()) {
						pojo.setId(rsKeys.getInt(1));
						resultado = true;
					}
				}				
			}
			
			ResultSet rs = pst.getGeneratedKeys();
			

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

	/**
	 * Convierte un Resultado de la BD a un POJO
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Video mapper(ResultSet rs) throws SQLException {
		Video v = new Video();
		v.setId(rs.getInt("video_id"));
		v.setNombre(rs.getString("video_nombre"));
		v.setCodigo(rs.getString("codigo"));
		
		Usuario u = new Usuario();
		u.setId(rs.getInt("usuario_id"));
		u.setNombre(rs.getString("usuario_nombre"));
		
		
		v.setCategoria(new Categoria( rs.getInt("categoria_id"), rs.getString("categoria_nombre")));
		v.setUsuario(u);
		return v;
	}

}