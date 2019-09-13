package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.model.dao.RolDAO;
import com.ipartek.formacion.model.dao.UsuarioDAO;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/backoffice/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VIEW_INDEX = "usuario/index.jsp";
	public static final String VIEW_FORM = "usuario/formulario.jsp";
	public static final String VIEW_DETALLE = "usuario/detalle.jsp";
	public static String view = VIEW_INDEX;

	public static final String OP_LISTAR = "0";
	public static final String OP_GUARDAR = "23";
	public static final String OP_BORRAR = "4";
	public static final String OP_ELIMINAR = "hfd3";
	public static final String OP_DETALLE = "13";
	public static final String OP_BUSCAR = "5";

	public static final String OP_FORM = "1";
	public static final String OP_EDITAR = "2";

	private static UsuarioDAO usuarioDAO;
	private static RolDAO rolDAO;
	private static String op;

	private static ArrayList<Usuario> Usuarios;

	ValidatorFactory factory;
	Validator validator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDAO = UsuarioDAO.getInstance();
		rolDAO = RolDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
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
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		op = request.getParameter("op");
		if (op == null) {
			op = OP_LISTAR;
		}

		switch (op) {
		// lista todos
		case OP_LISTAR:
			listar(request, response);
			break;
		// llaman al formulario
		case OP_FORM: // llama al formulario para crear nuevo o modificar
			detalle(request, response);
			break;
		case OP_BORRAR: // llama al formulario de borrar
			detalle(request, response);
			break;
		case OP_DETALLE: // cargara el usuario entero
			detalle(request, response);
			break;
		// Realizan las acciones dentro del formulario
		case OP_GUARDAR:
			guardar(request, response);
			break;
		case OP_ELIMINAR:
			eliminar(request, response);
			break;
		// buscador de usuarios
		case OP_BUSCAR:
			buscar(request, response);
			break;
		default:
			listar(request, response);
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		Boolean isVisible = Boolean.parseBoolean(request.getParameter("isVisible"));

		// request.setAttribute("usuarios", usuarioDAO.getAll());
		request.setAttribute("usuarios", usuarioDAO.getAllVisible(isVisible));
		request.setAttribute("visible", isVisible);
		view = VIEW_INDEX;
	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("id") != null) {
			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);

			Usuario u = usuarioDAO.getById(id);
			request.setAttribute("usuario", u);

			request.setAttribute("roles", rolDAO.getAll());

			request.setAttribute("op", op);

		} else {
			request.setAttribute("usuario", new Usuario());
			request.setAttribute("op", op);
		}

		if (op.equals(OP_DETALLE)) {
			view = VIEW_DETALLE;
		} else {
			view = VIEW_FORM;
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		if (usuarioDAO.eliminar(id)) {
			request.setAttribute("mensaje", new Alert("success", "Registro Eliminado"));
		} else {
			request.setAttribute("mensaje", new Alert("danger", "ERROR, no se pudo eliminar"));
		}

		listar(request, response);
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		String contrasenya = request.getParameter("contrasenya");
		int idUsuario = Integer.parseInt(request.getParameter("id"));

		Usuario u = new Usuario();
		u.setId(idUsuario);
		u.setNombre(nombre);
		u.setContrasenya(contrasenya);

		Set<ConstraintViolation<Usuario>> violations = validator.validate(u);
		if (violations.isEmpty()) { // no hay violations de las validaciones, esta todo bien
			// llama al DAO
			// si id == -1 => INSERT
			// si id > 0 => UPDATE

			try {
				if (u.getId() == -1) {
					usuarioDAO.crear(u);
					listar(request, response);
					request.setAttribute("mensaje", new Alert("success", "Registro creado con exito"));
				} else {
					usuarioDAO.modificar(u);
					listar(request, response);
					request.setAttribute("mensaje", new Alert("success", "Registro modificado con exito"));
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensaje", new Alert("danger", "Tenemos un problema el codigo ya existe"));
			}

			request.setAttribute("usuario", u);

		} else { // hay violaciones de las validaciones

			String mensaje = "";

			for (ConstraintViolation<Usuario> violation : violations) {
				// += es para que guarde varios mensajes y no los pise
				mensaje += violation.getPropertyPath() + ": " + violation.getMessage() + "<br>";
			}
			request.setAttribute("mensaje", new Alert("warning", mensaje));
		}
		request.setAttribute("usuario", u);

		view = VIEW_INDEX;
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		String buscar = request.getParameter("buscar");
		request.setAttribute("usuarios", usuarioDAO.getAllByName(buscar));
		view = VIEW_INDEX;

	}

}
