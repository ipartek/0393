package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.dao.UsuarioDAO;

/**
 * Servlet implementation class VideoController
 */
@WebServlet("/backoffice/usuarios")
public class usuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String VIEW_INDEX = "usuarios/index.jsp";
	public static String view = VIEW_INDEX;

	private static UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("usuarios", usuarioDAO.getAll());

		request.getRequestDispatcher(view).forward(request, response);
	}

}
