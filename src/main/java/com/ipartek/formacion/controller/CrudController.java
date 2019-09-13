package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Servlet implementation class CrudController
 */
@WebServlet("/CrudController")
public abstract class CrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String view = "";

	public static final String OP_LISTAR = "0";
	public static final String OP_GUARDAR = "23";
	public static final String OP_BORRAR = "4";
	public static final String OP_ELIMINAR = "hfd3";
	public static final String OP_DETALLE = "13";
	public static final String OP_BUSCAR = "5";

	public static final String OP_FORM = "1";
	public static final String OP_EDITAR = "2";

	protected static String op;
	protected Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}

		switch (op) {
		// lista todos
		case OP_LISTAR:
			listar(request, response);
			break;
		// llaman al formulario
		case OP_FORM: // llama al formulario para crear nuevo o modificar
			detalle(request, response);
			break;
		case OP_BORRAR: // llama al formulario de borrar
			detalle(request, response);
			break;
		case OP_DETALLE: // cargara el usuario entero
			detalle(request, response);
			break;
		// Realizan las acciones dentro del formulario
		case OP_GUARDAR:
			guardar(request, response);
			break;
		case OP_ELIMINAR:
			eliminar(request, response);
			break;
		// buscador de usuarios
		case OP_BUSCAR:
			buscar(request, response);
			break;
		default:
			listar(request, response);
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);

	}

	protected abstract void listar(HttpServletRequest request, HttpServletResponse response);

	protected abstract void eliminar(HttpServletRequest request, HttpServletResponse response);

	protected abstract void guardar(HttpServletRequest request, HttpServletResponse response);

	protected abstract void detalle(HttpServletRequest request, HttpServletResponse response);

	protected abstract void buscar(HttpServletRequest request, HttpServletResponse response);

}
