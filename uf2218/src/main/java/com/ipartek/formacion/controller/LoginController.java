package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
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
		
		
		String usuario  = request.getParameter("usuario");
		String password = request.getParameter("pass");
		
		if ( "admin".equals(usuario) && "admin".equals(password)) {
			
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario", "Paco");
			
			request.setAttribute("mensaje", new Alert("success","Ongi Etorri " + usuario ) );			
			request.getRequestDispatcher("backoffice/index.jsp").forward(request, response);
			
		}else {
			
			request.setAttribute("mensaje", new Alert("danger","credenciales no correctas") );			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}	
		
		
	}

}
