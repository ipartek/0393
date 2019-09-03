
package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Usuario;

public class UsuarioDAO {
	
	private static UsuarioDAO INSTANCE = null;

	private UsuarioDAO() {
		super();
	}
	
	public static synchronized UsuarioDAO getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new UsuarioDAO();
		}
		
		return INSTANCE;
		
	}
	
	/**
	 * Compruab si existe el usuario en la base datos, lo busca por su nombre y conetrsenya
	 * @param nombre
	 * @param contrasenya
	 * @return Usuario con datos si existe, null en caso de no existir
	 */
	public Usuario existe (String nombre, String contrasena) {
		
		Usuario usuario = null;
		
		String sql = " SELECT id, nombre, contrasena " + " FROM usuario " + 
				" WHERE nombre = ? AND contrasena = ? ;";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
			){
			//Sustituir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasena);
			
			//ejecutar secuencia SQL y obtener Resultado
			try (ResultSet rs = pst.executeQuery()){
				
				if (rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasena(rs.getString("contrasena"));
				}
				
			} catch (Exception e) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public ArrayList<Usuario> getAll() {
		
		ArrayList<Usuario> listaUser = new ArrayList<Usuario>();
		String sql = "SELECT `id`, `nombre`, `contrasena` FROM `usuario` ORDER BY `id` DESC LIMIT 500";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				listaUser.add( mapper(rs) );
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaUser;
	}

	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId( rs.getInt("id") );
		u.setNombre( rs.getString("nombre"));
		u.setContrasena( rs.getString("contrasena"));
		return u;
	}
	
	
	
	
	
	
	
	
	
}

