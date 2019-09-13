package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.dao.CategoriaDAO;
import com.ipartek.formacion.model.dao.UsuarioDAO;
import com.ipartek.formacion.model.dao.VideoDAO;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
	private static CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
	private static VideoDAO videoDAO = VideoDAO.getInstance();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
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

		int numeroUsuariosReal = usuarioDAO.getAllVisible(true).size();
		int numeroUsuariosDelete = usuarioDAO.getAllVisible(false).size();
		int numeroCategorias = categoriaDAO.getAll().size();
		int numeroVideos = videoDAO.getAll().size();

		request.setAttribute("numeroVideos", numeroVideos);
		request.setAttribute("numeroUsuariosActivos", numeroUsuariosReal);
		request.setAttribute("numeroUsuariosEliminados", numeroUsuariosDelete);
		request.setAttribute("numeroCategorias", numeroCategorias);
		
		// request interna
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
