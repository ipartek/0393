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

	private final static String SQL_GET_ALL = "SELECT id, nombre FROM rol";

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
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	public Rol mapper(ResultSet rs) throws SQLException {
		Rol r = new Rol();
		r.setId(rs.getInt("id"));
		r.setNombre(rs.getString("nombre"));

		return r;
	}

}
