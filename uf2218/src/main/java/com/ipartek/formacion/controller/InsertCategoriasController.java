package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * 
 * Servlet implementation class InsertCategoriasController
 * 
 * Servlet para probar a realizar transciones con commit y forward
 */
@WebServlet("/backoffice/transaciones")
public class InsertCategoriasController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		// comprobar que este el .JAR de mysql
		Class.forName("com.mysql.jdbc.Driver");
		
		//conseguir una conexion
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","root")){
				
				con.setAutoCommit(false);
				String sql = "INSERT INTO categoria (nombre) VALUES (?)";
				PreparedStatement pst = null;
				for(int i = 0; i<5; i++) {
					pst = (PreparedStatement) con.prepareStatement(sql);
					pst.setString(1, "nombre"+ i);
					
					/* if (i == 3) {
						con.rollback();
					 	throw new Exception ("Peta a drede a medio del proceso");
					   }
					*/
					
					pst.executeUpdate();
					
				}// end for
				
				//con.rollback();
				con.commit();
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/backoffice/categoria").forward(request, response);
	}

}
