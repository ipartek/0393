package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDAO {
	private static UsuarioDAO INSTANCE = null;
	Usuario usuario=null;
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
	 * Comprueba si el usuario existe en la base de datos, lo busca por su mombre y
	 * contrasena
	 * 
	 * @param nombre
	 * @param contrasena
	 * @return Usuario con datos si existe, null en caso de no existir
	 */
	public Usuario existe(String nombre, String contrasena) {
		String sql = "select id, nombre, contrasena from usuario where nombre=\"?\" and contrasena = \"?\";";
		
		try(	Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setString(1, nombre);
			pst.setString(2, contrasena);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nomre"));
					usuario.setContrasena(rs.getString(contrasena));
				}
			}
		}catch(Exception e) {
			
		}
		return usuario;
	}

}
