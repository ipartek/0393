package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet implementation class AhorcadoController
 */
@WebServlet("/ahorcado")
public class AhorcadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_INDEX = "ahorcado/index.jsp";
	public static String view = VIEW_INDEX;
	
	public static final String OP_CARGAR = "0";
	public static final String OP_COMPROBAR_LETRA = "1"; 
	
	private static String palabra;
	private static char[] respuesta;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AhorcadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = request.getParameter("op");
		if (op == null) {
			//TODO
		}
		switch (op) {
		case OP_CARGAR:
			cargar(request, response);
			break;
		
		case OP_COMPROBAR_LETRA: 
			comprobarLetra(request, response);
			break;
		default:
			//TODO
			break;
		}		
		request.getRequestDispatcher(view).forward(request, response);

	}

	private void cargar(HttpServletRequest request, HttpServletResponse response) {
		palabra = request.getParameter("palabra").trim().toLowerCase();
		if (palabra.isEmpty()) {
			request.setAttribute("mensaje", new Alert("danger","Error no has introducido una palabra"));
		}
		int tamano = palabra.length();
		respuesta = new char[tamano];
		
		for (int i = 0; i < tamano; i++) {
			respuesta[i] = '_';
		}
		request.setAttribute("palabra", palabra);
		request.setAttribute("respuesta", respuesta);
		
	}

	private void comprobarLetra(HttpServletRequest request, HttpServletResponse response) {
		int tamano = palabra.length();
		char letra = request.getParameter("letra").trim().toLowerCase().charAt(0);
		for (int i = 0; i < tamano; i++) {
			if (letra == palabra.toUpperCase().charAt(i)) {
				respuesta[i] = letra;
			}
		}
		
		request.setAttribute("palabra", palabra);
		request.setAttribute("respuesta", respuesta);
	}

}
