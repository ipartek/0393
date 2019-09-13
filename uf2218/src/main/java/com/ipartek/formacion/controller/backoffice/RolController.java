package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.controller.ControladorCrud;
import com.ipartek.formacion.model.dao.CategoriaDAO;
import com.ipartek.formacion.model.pojo.Categoria;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/backoffice/roles")
public class RolController extends ControladorCrud {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_INDEX = "rol/index.jsp";
	public static final String VIEW_FORM  = "rol/formulario.jsp";
	
	private static final CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void listar(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<Categoria> lista = categoriaDAO.getAll();;
		request.setAttribute("roles", lista);
		view = VIEW_INDEX;
		
	}


	@Override
	protected void guardar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void buscar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}