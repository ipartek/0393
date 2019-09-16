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
		
		private static final String SQL_GET_ALL =  "SELECT id, nombre FROM categoria ORDER BY  id  ASC LIMIT 500;";
		private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM categoria WHERE id =?;";
		private static final String SQL_DELETE ="DELETE FROM categoria WHERE id = ?";
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
			} catch (Exception e) {

				e.printStackTrace();
			}
			return lista;
		}
		
		
		public Categoria getById(int id) {
			Categoria categoria = new Categoria();

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

				// sustituyo la 1º ? por la variable id
				pst.setInt(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						/*
						 * Video v = new Video(); v.setId( rs.getInt("id") ); v.setNombre(
						 * rs.getString("nombre")); v.setCodigo( rs.getString("codigo"));
						 */
						categoria = mapper(rs);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return categoria;
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
		
		
		
		/**
		 * Convierte un Resultado de la BD en un Pojo
		 * 
		 * @param rs
		 * @return
		 * @throws SQLException
		 */
		public Categoria mapper(ResultSet rs) throws SQLException {
			Categoria c = new Categoria();
			c.setId(rs.getInt("id"));
			c.setNombre(rs.getString("nombre"));
			return c;
		}
		
		
}
