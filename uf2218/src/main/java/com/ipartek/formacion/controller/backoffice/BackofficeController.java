package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.dao.UsuarioDAO;
import com.ipartek.formacion.model.dao.VideoDAO;
import com.ipartek.formacion.model.pojo.Usuario;
import com.ipartek.formacion.model.pojo.Video;

/**
 * Servlet implementation class BackofficeControler
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static VideoDAO videoDAO = VideoDAO.getInstance();
	private static UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();

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

		ArrayList<Video> listaVideos = videoDAO.getAll();
		ArrayList<Usuario> listaUsuarios = usuarioDAO.getAll();

		request.setAttribute("numeroVideos", listaVideos.size());
		request.setAttribute("numeroUsuarios", listaUsuarios.size());

		// request interna
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
