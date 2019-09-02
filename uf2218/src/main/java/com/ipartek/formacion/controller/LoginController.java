package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.model.dao.UsuarioDAO;
import com.ipartek.formacion.model.dao.VideoDAO;
import com.ipartek.formacion.model.pojo.Usuario;
import com.ipartek.formacion.model.pojo.Video;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO usuarioDAO;
	private static VideoDAO videoDAO;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
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

		String usuarioNombre = request.getParameter("nombre");
		String usuarioContra = request.getParameter("contra");
		
		Usuario usuario = usuarioDAO.existe(usuarioNombre, usuarioContra);

		if (usuario != null) {

			HttpSession session = request.getSession();
			// session.setMaxInactiveInterval( 60 * 5 ); // 5 min

			session.setAttribute("usuario", usuario) ;

			request.setAttribute("mensaje", new Alert("success", "Ongi Etorri " + usuarioNombre));

			String callback = (String) session.getAttribute("callback");

			if (callback == null) { 
				
				ArrayList<Video> listaVideos = videoDAO.getAll();
				request.setAttribute("numeroVideos", listaVideos.size());
				request.setAttribute("numeroUsuarios", 66);
				
				request.getRequestDispatcher("backoffice/index.jsp").forward(request, response);
			} else {
				session.removeAttribute("callback");
				response.sendRedirect(callback);
			}

		} else {

			request.setAttribute("mensaje", new Alert("danger", "credenciales no correctas"));
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

}
