package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IdiomaController
 */
@WebServlet("/i18n")
public class IdiomaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdiomaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idiomaSeleccionado = request.getParameter("idiomaSeleccionado");
		String language = "en";
		String country = "EN";
		
		String ruta= request.getParameter("ruta").split("uf2218/")[1];
		
		if (ruta == null) {
			ruta="ejemplos/i18n.jsp";
		}
		
		if ( idiomaSeleccionado != null ) {			
			language = idiomaSeleccionado.split("_")[0];
			country = idiomaSeleccionado.split("_")[1];
		}
		
		Locale locale = new Locale(language, country);				
		ResourceBundle properties = ResourceBundle.getBundle ( "i18n/i18nmessages", locale );

		//guardar en sesion el idioma seleccionado para JSPs
		HttpSession session = request.getSession();
		session.setAttribute("idiomaSeleccionado",idiomaSeleccionado);

		request.setAttribute("mensajeInicio", properties.getString("menu.inicio"));
		request.setAttribute("mensajeVideo", properties.getString("menu.video"));
		//request.setAttribute("mensajeIdioma", idiomaSeleccionado);
		
		/*
		if (ruta!=null) {
			request.getRequestDispatcher(ruta).forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		*/
		//request.getRequestDispatcher("ejemplos/i18n.jsp").forward(request, response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
