package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.model.dao.CategoriaDAO;
import com.ipartek.formacion.model.pojo.Categoria;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/backoffice/categoria")
public class CategoriaController extends CrudController {
	private static final long serialVersionUID = 1L;

	public static final String VIEW_INDEX = "categoria/index.jsp";
	public static final String VIEW_FORM = "categoria/formulario.jsp";
	public static final String VIEW_DETALLE = "categoria/detalle.jsp";

	private static CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriaController() {
		super();
		categoriaDAO = CategoriaDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	@Override
	protected void listar(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Categoria> lista = categoriaDAO.getAll();
		request.setAttribute("categorias", lista);
		view = VIEW_INDEX;
	}

	@Override
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		if (categoriaDAO.eliminar(id)) {
			request.setAttribute("mensaje", new Alert("success", "Registro Eliminado"));
		} else {
			request.setAttribute("mensaje", new Alert("danger", "ERROR, no se pudo eliminar"));
		}

		listar(request, response);

	}

	@Override
	protected void guardar(HttpServletRequest request, HttpServletResponse response) {
		int idCategoria = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");

		Categoria c = new Categoria();
		c.setId(idCategoria);
		c.setNombre(nombre);

		Set<ConstraintViolation<Categoria>> violations = validator.validate(c);
		if (violations.isEmpty()) { // no hay violations de las validaciones, esta todo bien
			// llama al DAO
			// si id == -1 => INSERT
			// si id > 0 => UPDATE

			try {
				if (c.getId() == -1) {
					categoriaDAO.crear(c);
					listar(request, response);
					request.setAttribute("mensaje", new Alert("success", "Registro creado con exito"));
				} else {
					categoriaDAO.modificar(c);
					listar(request, response);
					request.setAttribute("mensaje", new Alert("success", "Registro modificado con exito"));
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensaje", new Alert("danger", "Tenemos un problema el codigo ya existe"));
			}

			request.setAttribute("categoria", c);

		} else { // hay violaciones de las validaciones

			String mensaje = "";

			for (ConstraintViolation<Categoria> violation : violations) {
				// += es para que guarde varios mensajes y no los pise
				mensaje += violation.getPropertyPath() + ": " + violation.getMessage() + "<br>";
			}
			request.setAttribute("mensaje", new Alert("warning", mensaje));
		}
		request.setAttribute("categoria", c);

		view = VIEW_INDEX;
	}

	@Override
	protected void detalle(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("id") != null) {
			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);

			Categoria c = CategoriaDAO.getById(id);
			request.setAttribute("categoria", c);

			request.setAttribute("op", op);

		} else {
			request.setAttribute("categoria", new Categoria());
			request.setAttribute("op", op);
		}

		if (op.equals(OP_DETALLE)) {
			view = VIEW_DETALLE;
		} else {
			view = VIEW_FORM;
		}

	}

	@Override
	protected void buscar(HttpServletRequest request, HttpServletResponse response) {
		String buscar = request.getParameter("buscar");
		request.setAttribute("categorias", categoriaDAO.getAllByName(buscar));
		view = VIEW_INDEX;

	}

}
