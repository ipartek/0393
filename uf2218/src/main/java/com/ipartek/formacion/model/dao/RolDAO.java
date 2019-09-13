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
		String sql = "SELECT `id`, `nombre` FROM `Rol` ORDER BY `nombre` ASC LIMIT 500";

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

	public Rol mapper(ResultSet rs) throws SQLException {
		Rol c = new Rol();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

	public Rol getById(int id) {
		Rol rol = new Rol();
		String sql = "SELECT id, nombre FROM Rol WHERE id = ? ;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			// sustituyo la 1º ? por la variable id
			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {

					rol = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rol;
	}

}
