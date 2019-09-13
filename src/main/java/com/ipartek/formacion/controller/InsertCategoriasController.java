package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertCategoriasController
 */
@WebServlet("/backoffice/transacciones")
public class InsertCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			// comprobar que este el .jar de mysql
			Class.forName("com.mysql.jdbc.Driver");

			// establecer conexion
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videos", "root", "root")) {
				con.setAutoCommit(false);
				String sql = "INSERT INTO categoria (nombre) VALUES (?)";
				PreparedStatement pst = null;
				for (int i = 0; i < 5; i++) {
					pst = con.prepareStatement(sql);
					pst.setString(1, "nombre" + 1);
					if (i == 3) {
						throw new Exception("peta adrede en medio del proceso");
					}

					pst.executeUpdate();

				} // end for
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
