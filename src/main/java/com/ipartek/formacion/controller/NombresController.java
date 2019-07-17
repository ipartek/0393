package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class NombresController
 */
@WebServlet("/nombres")
public class NombresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> listaNombres;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NombresController() {
		super();
		listaNombres =new ArrayList<String>();
		listaNombres.add("Manolo");
		listaNombres.add("Pepito");
		listaNombres.add("Ursiciano");
		listaNombres.add("Agapito");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Buscador 
		
		String buscar= request.getParameter("buscar");
		
		
		
		if( request.getParameter("buscar") == null || request.getParameter("buscar").isEmpty() ) {
			
			request.setAttribute("listaNombres", listaNombres);
		}
		
		
		
		request.setAttribute("mensaje", "TODO_mensaje");
		request.setAttribute("buscar", buscar);
		request.setAttribute("listaNombres", listaNombres);
		request.getRequestDispatcher("ejemplos/nombres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Añadir nuevo nombre
		
		
	}


}
