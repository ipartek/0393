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
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nombre  = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		
		Usuario usuario = usuarioDAO.existe(nombre, contrasena);
		
		if ( usuario != null) {		
			
			HttpSession session = request.getSession();
			
			if (usuario.getFechaEliminacion() != null) {
				request.setAttribute("mensaje", new Alert("danger","¡ATENCIÓN! Este usuario ha sido eliminado. Póngase en contacto con su administrador.") );	
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else {		
				
				session.setAttribute("usuario", usuario);
				//session.setAttribute("rol", rol);
				
				request.setAttribute("mensaje", new Alert("success","Ongi Etorri " + usuario.getNombre() ) );
				
				String callback = (String) session.getAttribute("callback");
				
				if ( callback == null ) {				
					response.sendRedirect("backoffice/inicio");
					
				}else {
					session.removeAttribute("callback");				
					response.sendRedirect(callback);
				}
			} //usuario.getFechaEliminacion() != null)
			
			
			
		}else {
			
			request.setAttribute("mensaje", new Alert("danger","Credenciales no correctas") );			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}	
		
	}

}
