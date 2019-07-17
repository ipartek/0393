package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListadoNombresController
 */
@WebServlet("/nombres")
public class ListadoNombresController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> lista;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoNombresController() {
        super();
        lista = new ArrayList<String>();
        lista.add("Manolo");
        lista.add("Hermenegilda");
        lista.add("Ursiciano");
        lista.add("Agapito");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buscar = request.getParameter("buscar");
		
		
		request.setAttribute("mensaje", "TODO_mensaje");
		request.setAttribute("buscar", buscar);
		request.setAttribute("nombres", lista);
		
		request.getRequestDispatcher("ejemplos/nombres.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
