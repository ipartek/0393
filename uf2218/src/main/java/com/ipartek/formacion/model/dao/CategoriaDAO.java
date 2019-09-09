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

	public Categoria create(Categoria pojo) {

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

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return pojo;
	}

	private Categoria mapper(ResultSet rs) throws SQLException {

		Categoria c = new Categoria();

		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));

		return c;
	}

}
