package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.dao.CategoriaDAO;
import com.ipartek.formacion.model.dao.UsuarioDAO;
import com.ipartek.formacion.model.dao.VideoDAO;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class BackOfficeController
 */
@WebServlet("/backoffice/inicio")
public class BackOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
	private static VideoDAO videoDAO = VideoDAO.getInstance();
	private static CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackOfficeController() {
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

		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario.getRol() == 1) {
			request.setAttribute("numeroVideosNoVisibles", videoDAO.getAllVisible(false).size());
			request.setAttribute("usuariosNoVisibles", usuarioDAO.getAllVisible(false).size());
			request.setAttribute("numeroCategorias", categoriaDAO.getAll().size());
		}

		request.setAttribute("numeroVideos", videoDAO.getAllVisible(true).size());
		request.setAttribute("numeroUsuarios", usuarioDAO.getAllVisible(true).size());

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
