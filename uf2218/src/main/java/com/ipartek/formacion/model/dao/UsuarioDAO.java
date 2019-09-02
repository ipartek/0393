package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Usuario;


public class UsuarioDAO {

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
		String sql = "SELECT id, nombre, contrasenya FROM usuario WHERE nombre = ? AND contrasenya = ?;";
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			){
			
			pst.setString(1,nombre);
			pst.setString(2,contrasenya);
			
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasenya(rs.getString("contarsenya"));
					
				}
			}
			
			
		} catch (Exception e) {
	
		}
		return usuario;
	}

}
