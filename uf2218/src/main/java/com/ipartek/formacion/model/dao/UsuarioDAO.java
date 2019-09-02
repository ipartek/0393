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

	public static synchronized UsuarioDAO getInstance() { //syncronized para que varias ejecuciones no se ejecuten a la vez
		
		if(INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
			
		}
		return INSTANCE;
	}
	
	//metodo para comprobar si un usuario existe
	public Usuario existe (String nombre, String contra) {
		
		Usuario usuario = null;
		
		String sql = "SELECT id, nombre, contra "
						+ " FROM videos_manu.usuario "
						+ " where nombre = ? and contra = ?";
		
		try(	Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			//sustituir ? por parámetros
			pst.setString(1, nombre);
			pst.setString(2, contra);
			
			//ejecutar sql y obtener resultado
			
			try (ResultSet rs = pst.executeQuery()) {
				if(rs.next()) {
					
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContra(rs.getString("contra"));
				}
			}
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
