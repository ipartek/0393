package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.controller.ControladorCrud;
import com.ipartek.formacion.model.dao.CategoriaDAO;
import com.ipartek.formacion.model.pojo.Categoria;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/backoffice/categorias")
public class CategoriaController extends ControladorCrud implements Servlet {
	private static final long serialVersionUID = 1L;

	public static final String VIEW_INDEX = "categorias/index.jsp";
	public static final String VIEW_FORM = "categorias/formulario.jsp";

	private static final CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	@Override
	protected void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("categorias", categoriaDAO.getAll());
		view = VIEW_INDEX;

	}

	@Override
	protected void IrAFormulario(HttpServletRequest request, HttpServletResponse response) {

		String sid = request.getParameter("id");

		Categoria c = new Categoria();
		if (sid != null) {
			int id = Integer.parseInt(sid);

			c = categoriaDAO.getById(id);

		}
		request.setAttribute("categoria", c);
		view = VIEW_FORM;

	}

	@Override
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void guardar(HttpServletRequest request, HttpServletResponse response) {

		String nombre = request.getParameter("nombre");
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);

		Categoria c = new Categoria();
		c.setNombre(nombre);

		if (id == -1) {

			c = categoriaDAO.create(c);
		} else {
			try {
				categoriaDAO.modificar(c);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		request.setAttribute("categoria", c);
		// TODO revisar metodo
	}

	@Override
	protected void buscar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
