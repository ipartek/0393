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
import com.ipartek.formacion.model.pojo.Youtube;

public class YoutubeDAO {

	private static YoutubeDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT v.id AS 'video_id', v.nombre AS 'video_nombre', codigo, u.id AS 'usuario_id', "
			+ "u.nombre AS 'usuario_nombre',c.id AS 'categoria_id', c.nombre AS 'categoria_nombre' "
			+ "FROM video AS v, usuario AS u, categoria AS c "
			+ "WHERE v.usuario_id = u.id AND v.categoria_id = c.id ORDER BY v.id DESC LIMIT 500";

	private static final String SQL_GET_BY_ID = "SELECT v.id AS 'video_id', v.nombre AS 'video_nombre', codigo, u.id AS 'usuario_id', "
			+ "u.nombre AS 'usuario_nombre',c.id AS 'categoria_id', c.nombre AS 'categoria_nombre' "
			+ "FROM video AS v, usuario AS u, categoria AS c "
			+ "WHERE v.usuario_id = u.id AND v.categoria_id = c.id AND v.id= ?";
	private static final String SQL_UPDATE = "UPDATE video SET nombre= ?, codigo= ? , usuario_id= ? , categoria_id= ? WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO video (nombre, codigo, usuario_id, categoria_id) VALUES (?,?,?,?);";
	private static final String SQL_DELETE = "DELETE FROM video WHERE id = ?;";

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

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
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

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {
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
	public boolean modificar(Youtube pojo, int usuarioId, int categoriaId) throws Exception {
		boolean resultado = false;
		// Usuario usuario = (Usuario) session.getAttribute("usuario");
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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean crear(Youtube pojo, int usuarioId, int categoriaId) throws Exception {
		boolean resultado = false;
		// Usuario usuario = (Usuario) session.getAttribute("usuario");
		// Categoria categoria = (Categoria) session.getAttribute("categoria");

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCodigo());
			pst.setInt(3, usuarioId);
			pst.setInt(4, categoriaId);

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

	public Youtube mapper(ResultSet rs) throws SQLException {
		Youtube video = new Youtube();
		video.setId(rs.getInt("video_id"));
		video.setNombre(rs.getString("video_nombre"));
		video.setCodigo(rs.getString("codigo"));

		Usuario u = new Usuario();
		u.setId(rs.getInt("usuario_id"));
		u.setNombre(rs.getString("usuario_nombre"));
		video.setUsuario(u);

		Categoria c = new Categoria();
		c.setId(rs.getInt("categoria_id"));
		c.setNombre(rs.getString("categoria_nombre"));
		video.setCategoria(c);

		return video;
	}

}