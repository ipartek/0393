package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

import com.ipartek.formacion.controller.ControllerCRUD;
import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.model.dao.CategoriaDAO;
import com.ipartek.formacion.model.pojo.Categoria;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/backoffice/categoria")
public class CategoriaController extends ControllerCRUD {
	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_INDEX = "categoria/index.jsp";
	public static final String VIEW_FORM = "categoria/formulario.jsp";
	
	private static CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();


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
		ArrayList<Categoria> lista = categoriaDAO.getAll(); 
		request.setAttribute("listaCategoria", lista);
		view = VIEW_INDEX;
		
	}

	@Override
	protected void buscar(HttpServletRequest request, HttpServletResponse response) {
		
		String nombreBuscar = request.getParameter("nombreBuscar");

		request.setAttribute("categorias", categoriaDAO.getAllByName(nombreBuscar));
		view = VIEW_INDEX;
		
	}

	@Override
	protected void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) {
		int idCategoria = Integer.parseInt(request.getParameter("id"));
		
		if (idCategoria == -1) {
			request.setAttribute("categoria", new Categoria());
			view = VIEW_FORM;
		} else {
			Categoria c = categoriaDAO.getById(idCategoria);
			request.setAttribute("categoria", c);
			view = VIEW_FORM;
		}
		
	}

	@Override
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));

		if (categoriaDAO.delete(id)) {
			request.setAttribute("mensaje", new Alert("success", "Categoria Eliminada"));
		} else {
			request.setAttribute("mensaje", new Alert("danger", "ERROR, no se pudo eliminar"));
		}

		listar(request, response);
		
	}

	@Override
	protected void guardar(HttpServletRequest request, HttpServletResponse response) {
		
		String nombre = request.getParameter("nombre");
		int idCategoria = Integer.parseInt(request.getParameter("id"));
		
		Categoria c = new Categoria();
		c.setId(idCategoria);
		c.setNombre(nombre);
		
		Set<ConstraintViolation<Categoria>> violations = validator.validate(c);
		if (violations.isEmpty()) {
			

			try {
				if (c.getId() == -1) {
					categoriaDAO.crear(c);
					idCategoria = c.getId();
				} else {
					categoriaDAO.modificar(c);
				}
				request.setAttribute("mensaje", new Alert("success", "Registro creado con exito"));

			} catch (Exception e) {

				request.setAttribute("mensaje", new Alert("danger", "Tenemos un problema, el codigo ya existe"));
			}

		} else { // hay violaciones de las validaciones

			String mensaje = "";

			for (ConstraintViolation<Categoria> violation : violations) {
				mensaje += violation.getPropertyPath() + ": " + violation.getMessage() + "<br>";
			}
			request.setAttribute("mensaje", new Alert("warning", mensaje));
		}
		request.setAttribute("video", categoriaDAO.getById(idCategoria));
		
	}

}
