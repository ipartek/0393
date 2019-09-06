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
