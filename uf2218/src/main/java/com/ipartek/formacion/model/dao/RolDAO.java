package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Rol;

public class RolDAO {

	private static RolDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT id,nombre FROM rol ORDER BY id DESC LIMIT 500;";
	/*
	private static final String SQL_GET_BY_ID = "SELECT id,nombre,contrasena FROM usuario WHERE id = ?;";
	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT id,nombre,contrasena FROM usuario WHERE nombre LIKE ? ORDER BY nombre ASC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO usuario ( nombre, contrasena) VALUES ( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ?, contrasena= ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	*/

	private RolDAO() {
		super();
	}

	public static synchronized RolDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}

		return INSTANCE;

	}

	

	public ArrayList<Rol> getAll() {

		ArrayList<Rol> lista = new ArrayList<Rol>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {				
				lista.add(mapper(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	
	private Rol mapper(ResultSet rs) throws SQLException {
		Rol c = new Rol();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));		
		return c;
	}

}