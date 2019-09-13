package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ControllerCrud  extends HttpServlet{

	public static String view="";
	
	private static final long serialVersionUID = 1L;
	
	public static final String OP_LISTAR = "0";
	public static final String OP_GUARDAR = "1";
	public static final String OP_NUEVO = "2";
	public static final String OP_ELIMINAR = "3";
	public static final String OP_MOSTRAR_FORMULARIO = "4";
	public static final String OP_BUSCAR = "5";
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}

		switch (op) {
		case OP_MOSTRAR_FORMULARIO:
			mostrarFomulario(request, response);
			break;

		case OP_GUARDAR:
			guardar(request, response);
			break;

		case OP_ELIMINAR:
			eliminar(request, response);
			break;

		case OP_NUEVO:
			nuevo(request, response);
			break;
		case OP_BUSCAR:
			buscar(request, response);
			break;

		default:
			listar(request, response);
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);
	}
	
	
	protected abstract void mostrarFomulario(HttpServletRequest request, HttpServletResponse response);
	protected abstract void guardar(HttpServletRequest request, HttpServletResponse response);
	protected abstract void eliminar(HttpServletRequest request, HttpServletResponse response);
	protected abstract void nuevo(HttpServletRequest request, HttpServletResponse response);
	protected abstract void buscar(HttpServletRequest request, HttpServletResponse response);
	protected abstract void listar(HttpServletRequest request, HttpServletResponse response);
	
}
