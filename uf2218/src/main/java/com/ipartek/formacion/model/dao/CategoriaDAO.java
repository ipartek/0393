package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.model.ConnectionManager;
import com.ipartek.formacion.model.pojo.Categoria;
import com.ipartek.formacion.model.pojo.Usuario;

public class CategoriaDAO {

	private static CategoriaDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT id,nombre FROM categoria ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM categoria WHERE id = ?;";
	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT id, nombre FROM categoria WHERE nombre LIKE ? ORDER BY nombre ASC LIMIT 500;";
	private static final String SQL_INSERT = "INSERT INTO categoria ( nombre) VALUES ( ? );";
	private static final String SQL_UPDATE = "UPDATE categoria SET nombre= ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM categoria WHERE id = ?;";
	

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

	
	public ArrayList<Categoria> getAllByNombre(String nombre) {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_NOMBRE);) {

			pst.setString(1, "%" + nombre + "%");

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					lista.add(mapper(rs));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Categoria getById(int id) {
		Categoria resul = new Categoria();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					resul = mapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	
	public Categoria crear(Categoria pojo) throws Exception {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguimos el ID que acabamos de crear
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}

			}

		}

		return pojo;
	}
	
	
	public boolean delete(int id) {
		boolean resultado = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();
			if (affetedRows == 1) {
				resultado = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean modificar(Categoria pojo) throws Exception {
		boolean resultado = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}




}