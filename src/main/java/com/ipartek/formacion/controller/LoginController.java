package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.model.dao.UsuarioDAO;
import com.ipartek.formacion.model.pojo.Rol;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAO usuarioDAO;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDAO = UsuarioDAO.getInstance();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String contrasenya = request.getParameter("contrasenya");

		Usuario usuario = usuarioDAO.existe(nombre, contrasenya);

		if (usuario != null) {
			// crear una sesion para el navegador
			HttpSession session = request.getSession();
			// session.setMaxInactiveInterval(60 * 5); //5 minutos

			// preguntar si esta dado de baja
			if (usuario.getFechaEliminacion() != null) {
				session.setAttribute("mensaje",
						new Alert("danger", "El usuario " + usuario.getNombre() + " ha sido eliminado"));
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {

				session.setAttribute("usuario", usuario);

				request.setAttribute("mensaje", new Alert("success", "Ongi Etorri " + usuario));

				// guardamos a donde intentaba ir para que sea redirigido alli despues de
				// loguearse
				String callback = (String) request.getAttribute("callback");
				if (callback == null) {
					if (usuario.getRol().getId() == Rol.ROL_ADMINISTRADOR) {
						// Redireccion para cambiar la url de "/login" a "/backoffice/inicio"
						response.sendRedirect("backoffice/inicio");
					} else {
						response.sendRedirect("frontoffice/index.jsp");
					}

				} else {
					session.removeAttribute("callback");
					response.sendRedirect(callback);
				}
			} // end preguntar si esta dado de baja

		} else {
			request.setAttribute("mensaje", new Alert("danger", "credenciales no correctas"));
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
