package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Categoria;

public class CategoriaDAO {

	private static CategoriaDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT id,nombre FROM categoria ORDER BY id DESC LIMIT 500;";
	/*
	private static final String SQL_GET_BY_ID = "SELECT id,nombre,contrasenya FROM usuario WHERE id = ?;";
	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT id,nombre,contrasenya FROM usuario WHERE nombre LIKE ? ORDER BY nombre ASC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO usuario ( nombre, contrasenya) VALUES ( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ?, contrasenya= ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	*/

	private CategoriaDAO() {
		super();
	}

	public static synchronized CategoriaDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}

		return INSTANCE;

	}

	

	public ArrayList<Categoria> getAll() {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();

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

	
	private Categoria mapper(ResultSet rs) throws SQLException {
		Categoria c = new Categoria();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));		
		return c;
	}

}