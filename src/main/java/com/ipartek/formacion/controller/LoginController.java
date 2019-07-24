package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("pass");
		if("admin".equals(usuario) && "admin".equals(password)){
			//crear una sesion para el navegador
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(60 * 5); //5 minutos
			
			session.setAttribute("usuario", "usuario"+request.getLocalAddr());
			
			request.setAttribute("mensaje", new Alert("success","Ongi Etorri " + usuario ) );
			
			//guardamos a donde intentaba ir para que sea redirigido alli despues de loguearse
			String callback = (String) request.getAttribute("callback");
			if (callback==null) {
				//request.getRequestDispatcher("backoffice/index.jsp").forward(request, response);
				request.getRequestDispatcher("backoffice/videos").forward(request, response);
			}else {
				session.removeAttribute("callback");
				response.sendRedirect(callback);
			}
		
		}else {
			request.setAttribute("mensaje", new Alert("danger", "credenciales no correctas"));
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
