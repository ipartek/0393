package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdiomaController
 */
@WebServlet("/i18n")
public class IdiomaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idiomaSeleccionado = request.getParameter("idiomaSeleccionado");
		
		if ( idiomaSeleccionado == null ) {
			//TODO comprobar null
		}
		
		Locale locale = new Locale("en_EN");		
		ResourceBundle properties = ResourceBundle.getBundle ( "i18n/i18nmessages", locale );
		
		
		request.setAttribute("mensajeIdioma", properties.getString("menu.inicio") );
		
		// request.setAttribute("mensajeIdioma", idiomaSeleccionado);
		
		request.getRequestDispatcher("ejemplos/i18n.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
