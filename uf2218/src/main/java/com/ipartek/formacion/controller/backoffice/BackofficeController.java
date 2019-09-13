package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.dao.CategoriaDAO;
import com.ipartek.formacion.model.dao.RolDAO;
import com.ipartek.formacion.model.dao.UsuarioDAO;
import com.ipartek.formacion.model.dao.VideoDAO;
import com.ipartek.formacion.model.pojo.Categoria;
import com.ipartek.formacion.model.pojo.Rol;
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
	private static RolDAO rolDAO;
	private static CategoriaDAO categoriaDAO;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDAO = UsuarioDAO.getInstance();
		videoDAO = VideoDAO.getInstance();
		categoriaDAO = CategoriaDAO.getInstance();
		rolDAO = RolDAO.getInstance();
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
		ArrayList<Usuario> listaUsuariosVisible = usuarioDAO.getAllVisible(true);
		ArrayList<Usuario> listaUsuariosEliminados = usuarioDAO.getAllVisible(false);
		ArrayList<Categoria> listaCategorias = categoriaDAO.getAll();
		ArrayList<Rol> listaRoles = rolDAO.getAll();

		request.setAttribute("totalUsuariosVisibles", listaUsuariosVisible.size());
		request.setAttribute("totalUsuariosEliminados", listaUsuariosEliminados.size());
		request.setAttribute("totalVideos", listaVideos.size());
		request.setAttribute("totalRoles", listaRoles.size());

		// request interna
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
