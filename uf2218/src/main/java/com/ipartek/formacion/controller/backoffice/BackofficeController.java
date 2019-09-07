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
		ArrayList<Usuario> listaUsuarios = usuarioDAO.getAll();

		request.setAttribute("numeroVideos", listaVideos.size()); // videoDAO.getAll().size();
		request.setAttribute("numeroUsuarios", listaUsuarios.size());
		
	
		// TODO preguntar por la siguiente prueba
		/* ¿Es una buena idea hacer aqui las consultas getAll 1 vez y recogerlas como ArrayList en VideoController?
		 * Asi se ahorraria por ejemplo consultar 3 veces a la base de datos cada vez que el admin ve el detalle de 1 video,
		 * en vez de eso se consultarian las categorias o los usuarios a traves de ArrayList disponibles en el controlador.
		 * Al modificar, crear o borrar una fila, se podría hacer el cambio en la BD con el dao y modificar la ArrayList
		 * que se mandará como atributo (pero sin conseguir/sobreescribir esta mediante un nuevo dao.getAll() ) 
		 * 
		 * */
		

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
