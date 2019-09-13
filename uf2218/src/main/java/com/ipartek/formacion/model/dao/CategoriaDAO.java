package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Categoria;

public class CategoriaDAO {

	private static CategoriaDAO INSTANCE = null;

	private static String SQL_GET_ALL = "SELECT id, nombre" + " FROM categoria;";

	private static String SQL_GET_BY_ID = "SELECT id, nombre" + " FROM categoria" + " WHERE id = ?;";

	private static String SQL_NEW = "INSERT INTO categoria (nombre) VALUES (?);";

	private static String SQL_UPDATE = "UPDATE categoria SET nombre = ? WHERE id = ?";
	
	private static String SQL_DELETE = "DELETE FROM categoria WHERE id = ?";

	public static synchronized CategoriaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		return INSTANCE;
	}

	private CategoriaDAO() {
		super();
	}

	public ArrayList<Categoria> getAll() {

		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				categorias.add(mapper(rs));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return categorias;
	}

	public Categoria getById(int id) {

		Categoria categoria = new Categoria();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

			// sustituyo la 1º ? por la variable id
			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {

					categoria = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoria;
	}

	public Categoria create(Categoria pojo) throws Exception{

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_NEW, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());

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

	private Categoria mapper(ResultSet rs) throws SQLException {

		Categoria c = new Categoria();

		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));

		return c;
	}

	public boolean modificar(Categoria pojo) throws Exception {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());

			pst.setInt(2, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}
	
	public boolean delete(int id) throws Exception{
		
		boolean borrado = false;
		
		try(Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(SQL_DELETE)){
			
			pst.setInt(1, id);
			
			int affectedRows = pst.executeUpdate();
			
			if(affectedRows == 1) {
				borrado = true;
			}

		}
		
		
		return borrado;
	}

}
