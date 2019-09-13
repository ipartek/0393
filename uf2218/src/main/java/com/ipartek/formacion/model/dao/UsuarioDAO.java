package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Rol;
import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDAO {
	Rol rol = new Rol();
	private static UsuarioDAO INSTANCE = null;

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
	 * Comprueba si existe el usuario en la base de datos, lo busca por su nombre y
	 * contrasenya
	 * 
	 * @param nombre
	 * @param contrasenya
	 * @return Usuario con datos si existe, null en caso de no existir
	 */
	public Usuario existe(String nombre, String contrasenya) {
		Usuario usuario = null;
		String sql = "SELECT id, nombre, contrasenya, id_rol, fecha_creacion, fecha_eliminacion FROM usuario WHERE nombre = ? AND contrasenya = ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, nombre);
			pst.setString(2, contrasenya);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasenya(rs.getString("contarsenya"));
					rol.setId(rs.getInt("id_rol"));
					usuario.setRol(rol);
				}
			}

		} catch (Exception e) {

		}
		return usuario;
	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT `id`, `nombre`, `contrasenya`,`id_rol`, `fecha_creacion`, `fecha_eliminacion` FROM `usuario` ORDER BY `id` ASC LIMIT 500";

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
	
	
	public ArrayList<Usuario> getAllVisible(boolean isVisible) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT `id`, `nombre`, `contrasenya`, `id_rol`, `fecha_creacion`, `fecha_eliminacion` FROM `usuario` WHERE fecha_eliminacion IS NULL  ORDER BY `id` ASC LIMIT 500;";
		if(!isVisible) {
			sql = "SELECT `id`, `nombre`, `contrasenya`, `id_rol`, `fecha_creacion`, `fecha_eliminacion` FROM `usuario` WHERE fecha_eliminacion is not null  ORDER BY `id` ASC LIMIT 500";
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

	public Usuario getById(int id) {
		Usuario user = new Usuario();
		String sql = "SELECT id, nombre, contrasenya, id_rol, fecha_creacion, fecha_eliminacion FROM usuario WHERE id = ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			// sustituyo la 1º ? por la variable id
			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					/*
					 * Video v = new Video(); v.setId( rs.getInt("id") ); v.setNombre(
					 * rs.getString("nombre")); v.setCodigo( rs.getString("codigo"));
					 */
					user = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<Usuario> getAllByName(String buscar) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT `id`, `nombre`, `contrasenya`, `id_rol`, `fecha_creacion`, `fecha_modificacion` FROM `usuario` WHERE nombre LIKE ? ORDER BY `id` ASC LIMIT 500";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, '%' + buscar + '%');
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					lista.add(mapper(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public boolean modificar(Usuario pojo) throws Exception {
		boolean resultado = false;

		String sql = "UPDATE usuario SET nombre = ?, contrasenya = ? WHERE  id = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());
			pst.setInt(3, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	public Usuario crear(Usuario pojo) throws Exception {
		String sql = "INSERT INTO usuario (nombre, contrasenya,id_rol) VALUES (?,?);";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenya());
			pst.setInt(3,pojo.getRol().getId());
			
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

	public boolean delete(int id) {
		boolean resultado = false;
		String sql = "UPDATE usuario SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE  id = ?;";

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
	 * Convierte un Resultado de la BD en un Pojo
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasenya(rs.getString("contrasenya"));
		u.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
		u.setFecha_eliminacion(rs.getTimestamp("fecha_eliminacion"));
		return u;
	}

}
