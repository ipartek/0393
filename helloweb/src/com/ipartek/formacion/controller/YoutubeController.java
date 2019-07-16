package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.Youtube;

/**
 * Servlet implementation class YoutubeController
 */
@WebServlet("/crear-video")
public class YoutubeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW_FORMULARIO = "youtube/formulario.jsp";
	private static final String VIEW_DETALLE = "youtube/detalle.jsp";
	private String view = VIEW_DETALLE;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recibir parametros del usuario
		String titulo = request.getParameter("titulo");
		String codigo = request.getParameter("codigo");
		
		//validar
		try {
			Youtube video = new Youtube(titulo, codigo);
			request.setAttribute("video", video );
			view = VIEW_DETALLE;
		
		}catch (Exception e) {
			view = VIEW_FORMULARIO;
			request.setAttribute("mensaje", e.getMessage() );
			
		}	
		
		// Ir a una JSP		
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
