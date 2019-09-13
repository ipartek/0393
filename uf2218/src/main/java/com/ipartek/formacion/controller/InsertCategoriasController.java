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
 * Servler de ejemplo para probar a realizar transacciones con commit y rollback
 */
@WebServlet("/backoffice/transacciones")
public class InsertCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCategoriasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videos","root","root")){
				con.setAutoCommit(false);
				String sql = "INSERT INTO categoria(nombre) VALUES(?)";
					PreparedStatement pst=null;
				for(int i= 0; i<5; i++) {
					pst = con.prepareStatement(sql);
					pst.setString(1, "nombre"+i);
					
					/*
					 if(i==3){
					 con.rollback();
					 throw new Exception("Peta adrede en medio del proceso");
					 }
					  
					 */
					pst.executeUpdate();
					
				}
				con.commit();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		request.getRequestDispatcher("/backoffice/categoria").forward(request, response);
	}

}
