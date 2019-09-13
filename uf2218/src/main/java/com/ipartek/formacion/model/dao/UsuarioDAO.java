package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Rol;
import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT "
			+ " u.id as 'usuario_id', u.nombre as 'usuario_nombre', u.fecha_creacion as 'fecha_creacion', u.fecha_eliminacion as 'fecha_eliminacion', u.contrasenya as 'usuario_contrasenya', r.id as 'rol_id', "
			+ " r.nombre as 'rol_nombre' " + " FROM usuario as u , rol as r " + " WHERE u.id_rol = r.id "
			+ " ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_ALL_ACTIVO = "SELECT "
			+ " u.id as 'usuario_id', u.nombre as 'usuario_nombre', u.fecha_creacion as 'fecha_creacion', u.fecha_eliminacion as 'fecha_eliminacion', u.contrasenya as 'usuario_contrasenya', r.id as 'rol_id', "
			+ " r.nombre as 'rol_nombre' " + " FROM usuario as u , rol as r " + " WHERE u.id_rol = r.id "
			+ " AND u.fecha_eliminacion IS NULL ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_ALL_IN_ACTIVO = "SELECT "
			+ " u.id as 'usuario_id', u.nombre as 'usuario_nombre', u.fecha_creacion as 'fecha_creacion', u.fecha_eliminacion as 'fecha_eliminacion', u.contrasenya as 'usuario_contrasenya', r.id as 'rol_id', "
			+ " r.nombre as 'rol_nombre' " + " FROM usuario as u , rol as r " + " WHERE u.id_rol = r.id "
			+ " AND u.fecha_eliminacion IS NOT NULL ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT "
			+ " u.id as 'usuario_id', u.nombre as 'usuario_nombre', u.fecha_creacion as 'fecha_creacion', u.fecha_eliminacion as 'fecha_eliminacion', u.contrasenya as 'usuario_contrasenya', r.id as 'rol_id', "
			+ " r.nombre as 'rol_nombre' " + " FROM usuario as u , rol as r " + " WHERE u.id_rol = r.id AND u.id = ? "
			+ " ORDER BY u.id DESC LIMIT 500;";

	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT "
			+ " u.id as 'usuario_id', u.nombre as 'usuario_nombre', u.fecha_creacion as 'fecha_creacion', u.fecha_eliminacion as 'fecha_eliminacion', u.contrasenya as 'usuario_contrasenya', r.id as 'rol_id', "
			+ " r.nombre as 'rol_nombre' " + " FROM usuario as u , rol as r "
			+ " WHERE u.id_rol = r.id AND u.nombre LIKE ? " + " ORDER BY u.id DESC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO usuario ( nombre, contrasenya) VALUES ( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ?, contrasenya= ?, id_rol= ? WHERE id = ?;";
	private static final String SQL_DELETE = "UPDATE usuario SET fecha_eliminacion= CURRENT_TIMESTAMP() WHERE id = ?;";
	private static final String SQL_EXISTE = "SELECT id, nombre, contrasenya FROM usuario WHERE nombre = ? AND contrasenya = ? AND fecha_eliminacion IS NULL ;";

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
	 * compruba si existe el usuario en la base de datos, lo busca por su nombrey
	 * contrsenya
	 * 
	 * @param nombre
	 * @param contrasenya
	 * @return usuario con datos si existe, null en caso de no existir
	 */

	public Usuario existe(String nombre, String contrasenya) {

		Usuario usuario = null;
		String sql = SQL_EXISTE;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			// sustuuir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasenya);

			// ejecutar sentencia SQL y obtener resultado
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasenya(rs.getString("contrasenya"));

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return usuario;

	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = SQL_GET_ALL;

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

	public ArrayList<Usuario> getAllActivos(boolean isActivo) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = SQL_GET_ALL_ACTIVO;
		if (!isActivo) {
			sql = SQL_GET_ALL_IN_ACTIVO;
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

	public Usuario getById(int id) {
		Usuario usuario = new Usuario();
		String sql = SQL_GET_BY_ID;

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

	public boolean modificar(Usuario pojo, String id_rol) throws Exception {
		boolean resultado = false;

		String sql = SQL_UPDATE;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());
			pst.setString(3, id_rol);
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
		String sql = SQL_DELETE;

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

	public boolean crear(Usuario pojo) throws Exception {
		boolean resultado = false;
		String sql = SQL_INSERT;

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());

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

	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("usuario_id"));
		u.setNombre(rs.getString("usuario_nombre"));
		u.setContrasenya(rs.getString("usuario_contrasenya"));
		u.setFechaCreacion(rs.getDate("fecha_creacion"));
		u.setFechaEliminacion(rs.getDate("fecha_eliminacion"));
		u.setRol(new Rol(rs.getInt("rol_id"), rs.getString("rol_nombre")));
		return u;
	}

}
