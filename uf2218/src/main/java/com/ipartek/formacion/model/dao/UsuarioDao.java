package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDao {

	private static UsuarioDao INSTANCE = null;

	private UsuarioDao() {

		super();

	}

	public static synchronized UsuarioDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDao();
		}

		return INSTANCE;

	}

	/*
	 * 
	 * 
	 * Comprueva si existe el usuario en la base de datos, lo busca por su nombre y
	 * contrasena
	 * 
	 * 
	 * @param nombre
	 * 
	 * @param contrasena
	 * 
	 * @param Usuario con datos si existe,null en caso de no existir
	 */

	public Usuario existe(String nombre, String contrasena) {

		Usuario usuario = null;

		String sql = "SELECT id, nombre,contrasena " + " FROM usuario " + " WHERE nombre = ? AND contrasena= ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);

		) {

			// Sustituir ? por paramentros

			pst.setString(1, nombre);
			pst.setString(2, contrasena);

			// ejecutar ssentencia SQL

			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {

					usuario = new Usuario();

					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasena(rs.getString("contrasena"));

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;

	}

}
