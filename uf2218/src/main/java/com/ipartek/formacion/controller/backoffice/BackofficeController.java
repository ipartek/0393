package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
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
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UsuarioDAO usuarioDAO;
	private static VideoDAO videoDAO;

	public void init(ServletConfig config) throws ServletException {

		usuarioDAO = UsuarioDAO.getInstance();
		videoDAO = VideoDAO.getInstance();

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

		ArrayList<Video> listaVideos = videoDAO.getAll();

		// ArrayList<Video> listaVideos = videoDAO.getAllVisible(true); // videos
		// visibles
		// ArrayList<Video> listaVideosNoVisibles = videoDAO.getAllVisible(false); //
		// videos no visibles

		request.setAttribute("numeroVideos", listaVideos.size()); // videoDAO.getAll().size();
		// request.setAttribute("numeroVideosNoVisibles", listaVideosNoVisibles.size());

		// ArrayList<Usuario> listaUsuarios = usuarioDAO.getAll();
		ArrayList<Usuario> listaUsuariosActivos = usuarioDAO.getAllVisible(true);
		ArrayList<Usuario> listaUsuariosEliminados = usuarioDAO.getAllVisible(false);
		request.setAttribute("numeroUsuariosActivos", listaUsuariosActivos.size());
		request.setAttribute("numeroUsuariosEliminados", listaUsuariosEliminados.size());

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
