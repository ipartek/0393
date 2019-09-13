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

	// private static final String SQL_GET_ALL = "SELECT c.id AS 'categoria_id',
	// c.nombre AS 'categoria_nombre' FROM categoria AS c ORDER BY id ASC LIMIT
	// 500;";
	private static final String SQL_GET_ALL = "SELECT id, nombre FROM categoria ORDER BY id ASC LIMIT 500;";
	private static final String SQL_EXISTE = "SELECT id, nombre FROM categoria WHERE nombre = ?;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM categoria WHERE id = ?;";
	private static final String SQL_UPDATE = "UPDATE categoria SET nombre = ? WHERE  id = ?;";
	private static final String SQL_DELETE = "DELETE FROM categoria WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO categoria (nombre) VALUES (?);";
	private static final String SQL_GET_BY_NAME = "SELECT id, nombre FROM categoria WHERE nombre LIKE ? ORDER BY id ASC LIMIT 500;";

	private CategoriaDAO() {
		super();
	}

	public static CategoriaDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		return INSTANCE;
	}

	/**
	 * Comprueba si existe la categoria en la base de datos, lo busca por su nombre
	 * 
	 * @param nombre
	 * @return Categoria con datos si existe, null en caso de no existir
	 * @throws SQLException
	 */
	public Categoria existe(String nombre) {
		Categoria categoria = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);) {

			// sustituir ? por parametros
			pst.setString(1, nombre);

			// ejecutar sentencia SQL y obtener Resultado
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					categoria = new Categoria();
					categoria.setId(rs.getInt("id"));
					categoria.setNombre(rs.getString("nombre"));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return categoria;
	}

	public ArrayList<Categoria> getAll() {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();

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

	public static Categoria getById(int id) {
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

	public boolean eliminar(int id) {
		boolean resultado = false;
		// String sql = "DELETE FROM usuario WHERE id = ?;";

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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public ArrayList<Categoria> getAllByName(String buscar) {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_NAME)) {

			pst.setString(1, '%' + buscar + '%'); // busca todos, los que contengan esa letra/palabra
			// pst.setString(1,buscar + '%'); //busca los que empiecen por esa letra/palabra

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					lista.add(mapper(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static Categoria mapper(ResultSet rs) throws SQLException {
		Categoria categoria = new Categoria();
		categoria.setId(rs.getInt("id"));
		categoria.setNombre(rs.getString("nombre"));

		return categoria;
	}
}
