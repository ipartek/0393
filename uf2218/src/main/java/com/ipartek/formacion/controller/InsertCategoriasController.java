package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet de ejemplo para probar a realizar transacciones con commit y rollback
 */
@WebServlet("/backoffice/transacciones")
public class InsertCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// comprobar que este el .jar de mysql
			Class.forName("com.mysql.jdbc.Driver");

			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/v2019", "root", "root");) {

			}
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
