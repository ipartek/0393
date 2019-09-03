package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.dao.UsuarioDAO;
import com.ipartek.formacion.model.dao.YoutubeDAO;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO usuarioDAO;
	private static YoutubeDAO youtubeDAO;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDAO = UsuarioDAO.getInstance();
		youtubeDAO = YoutubeDAO.getInstance();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackofficeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// llamar DAO de videos y DAO de users para saber cuantos hay de cada
		request.setAttribute("numeroVideos", youtubeDAO.getAll().size());
		request.setAttribute("numeroUsuarios", usuarioDAO.getAll().size());

		// request interna
		request.getRequestDispatcher("/backoffice/index.jsp").forward(request, response);
		// request.getRequestDispatcher("backoffice/videos").forward(request, response);
	}

}
