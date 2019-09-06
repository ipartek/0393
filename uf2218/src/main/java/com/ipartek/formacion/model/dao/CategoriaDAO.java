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

	private CategoriaDAO() {
		super();
	}

	public static synchronized CategoriaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		return INSTANCE;
	}

	/**
	 * compruba si existe el usuario en la base de datos, lo busca por su nombrey
	 * contrsenya
	 * 
	 * @param nombre
	 * @param contrasenya
	 * @return usuario con datos si existe, null en caso de no existir
	 */

	public ArrayList<Categoria> getAll() {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		String sql = SQL_GET_ALL;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				lista.add(mapper(rs));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	public Categoria mapper(ResultSet rs) throws SQLException {
		Categoria v = new Categoria();
		v.setId(rs.getInt("id"));
		v.setNombre(rs.getString("nombre"));
		return v;
	}

}
