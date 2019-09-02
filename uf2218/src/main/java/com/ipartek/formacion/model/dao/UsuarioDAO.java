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
	 * compruba si existe el usuario en la base de datos, lo busca por su nombrey contrsenya
	 * @param nombre
	 * @param contrasenya
	 * @return usuario con datos si existe, null en caso de no existir 
	 */
	
	public Usuario existe(String nombre, String contrasenya) {
		
		Usuario usuario = null;
		String sql ="SELECT id, nombre, contrasenya FROM usuario WHERE nombre = ? AND contrasenya = ? ;";
		
		try ( Connection con = ConnectionManager.getConnection();
			  PreparedStatement pst = con.prepareStatement(sql);
			 ) {

			//sustuuir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasenya);
			
			//ejecutar sentencia SQL y obtener resultado
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next())  {
					usuario =new Usuario();
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

}
