package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Servlet implementation class PerroController
 */
@WebServlet("/perros")
public class PerroController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    private ArrayList<Perro> perros = new ArrayList<Perro>();   
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nombre = request.getParameter("nombre");
		
		// TODO eliminar el perro del Arrahy
		
		request.setAttribute("mensaje", "Hemos sacrificado a " + nombre);
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perro/listado.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		String edad = request.getParameter("edad");
		String vacunado = request.getParameter("vacunado");
		
		Perro p = new Perro();
		p.setNombre(nombre);
		p.setRaza(raza);
		p.setEdad(Integer.parseInt(edad));
		p.setVacunado( (vacunado != null) ? true : false );
		
		perros.add(p);
		
		
		request.setAttribute("perro", p);
		request.setAttribute("perros", perros);		
		
		
		request.getRequestDispatcher("perro/listado.jsp").forward(request, response);
		
		
	}

}
