package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAgentController
 */
@WebServlet("/useragent")
public class UserAgentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAgentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mirar user-agent de la cabecera para saber el navegador y si usa movil
		String userAgent = request.getHeader("user-agent");
		userAgent= userAgent.toLowerCase();
		
		if(userAgent.contains("mobile")) {
			request.setAttribute("movil", true);
		}else {
			request.setAttribute("movil",false);
		}
		
		String navegador="";
		if(userAgent.contains("trident")) {
			navegador="internet explorer";
		}else if(userAgent.contains("opr")) {
			navegador="opera";	
		}else if(userAgent.contains("chrome")) {
			navegador="<i class=\"fab fa-chrome\"></i>chrome";			
		}else if(userAgent.contains("firefox")) {
			navegador="<i class=\"fab fa-firefox\"></i>Firefox";			
		}else{
			navegador="otro";
		}
		
		
		
		request.setAttribute("navegador", navegador);
		

		request.getRequestDispatcher("ejemplos/basico2.jsp").forward(request, response);
		
		
	}

}
