package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaludoController
 */
@WebServlet("/saludo/saludar")
public class SaludoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vista = "respuesta.jsp";
		
		//recibir parametros
		String nombre = request.getParameter("nombre");
		String idioma = request.getParameter("idioma");
		String repetir = request.getParameter("repetir");
		
		request.getRequestDispatcher( vista ).forward(request, response);
		
		//validar parametros
		
		if ( nombre == null || nombre.isEmpty() ) {
			
			request.setAttribute("mensaje", "Por favor dime tu nombre");
			vista = "formulario.jsp";
			
		}else {
		
				String htmlText = "";	
				
				if ( "es".equalsIgnoreCase(idioma) ) {
					htmlText = "Hola " + nombre;
					
				}else if ( "en".equalsIgnoreCase(idioma)) {
					htmlText = "WellCome " + nombre;
					
				}else {
					htmlText = "Ongi Etorri " + nombre;
				}
				
				/* 
				 * No vamos a maquetar nosotros la Response
				 * Mejor hacer una Request Interna a una JSP
				 * 
				PrintWriter out = response.getWriter();
				out.append("<h1>Pagina Saludo</h1>");
				out.append("<p>" + htmlText  + "</p>");
				*/
				
				//enviamos atributos para pintar en la JSP
				request.setAttribute("saludo", htmlText);
				request.setAttribute("repetir", repetir);
				
		}
		
		request.getRequestDispatcher( vista ).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
