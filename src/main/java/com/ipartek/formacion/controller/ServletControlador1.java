package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletControlador1
 */
@WebServlet("/controlador1")
public class ServletControlador1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControlador1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// obtener datos del cliente a traves de la REQUEST
		// dar una respuesta a traves de la RESPONSE
		
		PrintWriter  out = response.getWriter();
		out.print("<h1>Respuesta desde ServletControlador1</h1> ");
		
		out.print("<p>User-Agent <b>"+ request.getHeader("user-agent") +"</b></p>");
		
		//mirar version HTTP y mas cosas.
		
		out.print("<h2>Parametros</h2>");
		out.print("<ul>");
			Enumeration<String> eParamas = request.getParameterNames();
			while ( eParamas.hasMoreElements() ) {				
				String paramName = eParamas.nextElement();
				String paramValue = request.getParameter(paramName);
				out.print("<li>" + paramName + " <b>"+ paramValue +"</b></li>");					
			 }			
		out.print("</ul>");
		
		//todos los datos de la  cabecera
		Enumeration<String> header = request.getHeaderNames();
		out.print("<h2>Cabecera</h2> ");	 
		while(header.hasMoreElements()) {
			String headerName = header.nextElement();
			String headerValue = request.getHeader(headerName);
			out.print("<li>" + headerName + " <b>"+ headerValue +"</b></li>");	
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Tenemos el GET y el POST que hacen lo mismo
		doGet(request, response);		
	}

}