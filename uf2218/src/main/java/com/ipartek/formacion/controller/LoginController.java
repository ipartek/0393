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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");

		Usuario usuario = usuarioDAO.existe(nombre, contrasena);

		if (usuario != null) {

			if (usuario.getFechaEliminacion() != null) { // si entra, es un usuario eliminado

				request.setAttribute("mensaje", new Alert("danger", "Lo siento, usted fue dado de baja"));
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else { // fechaEliminacion == null, usuario activo

				HttpSession session = request.getSession();
				// session.setMaxInactiveInterval( 60 * 5 ); // 5 min

				session.setAttribute("usuario", usuario);

				request.setAttribute("mensaje", new Alert("success", "Ongi Etorri " + usuario.getNombre()));

				String callback = (String) session.getAttribute("callback");

				if (callback == null) {

					response.sendRedirect("backoffice/inicio");

				} else {
					session.removeAttribute("callback");
					response.sendRedirect(callback);
				}

			} // end: fechaEliminacion == null, usuario activo

		} else {

			request.setAttribute("mensaje", new Alert("danger", "credenciales no correctas"));
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

}
