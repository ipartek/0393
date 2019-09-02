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
import com.ipartek.formacion.model.dao.YoutubeDAO;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UsuarioDAO usuarioDAO;  
    private static YoutubeDAO youtubeDAO;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	usuarioDAO = UsuarioDAO.getInstance();
    	youtubeDAO = YoutubeDAO.getInstance();
    }
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
		String nombre=request.getParameter("nombre");
		String contrasenya=request.getParameter("contrasenya");
		
		Usuario usuario=usuarioDAO.existe(nombre, contrasenya);
		
		if(usuario!=null){
			//crear una sesion para el navegador
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(60 * 5); //5 minutos
			
			session.setAttribute("usuario", usuario);
			
			request.setAttribute("mensaje", new Alert("success","Ongi Etorri " + usuario ) );
			
			//guardamos a donde intentaba ir para que sea redirigido alli despues de loguearse
			String callback = (String) request.getAttribute("callback");
			if (callback==null) {
				// llamar DAO de videos y DAO de users para saber cuantos hay de cada
				request.setAttribute("numeroVideos", youtubeDAO.getAll().size());
				request.setAttribute("numeroUsuarios", usuarioDAO.getAll().size());
				
				request.getRequestDispatcher("backoffice/index.jsp").forward(request, response);
				//request.getRequestDispatcher("backoffice/videos").forward(request, response);
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
