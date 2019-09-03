package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.dao.UsuarioDAO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/backoffice/users")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UsuarioDAO usuarioDAO;

	public static final String VIEW_INDEX = "users/index.jsp";
	private static final String OP_LISTAR = "1";
	private static String view = VIEW_INDEX;

	public void init(ServletConfig config) throws ServletException {

		usuarioDAO = UsuarioDAO.getInstance();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");

		if (op == null) {
			op = OP_LISTAR;
		}

		switch (op) {

		case OP_LISTAR:
			listar(request, response);
			break;

		default:
			listar(request, response);
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("usuarios", usuarioDAO.getAll());

	}

}
