package com.ipartek.formacion.controller;

import java.io.IOException;
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
import com.ipartek.formacion.model.dao.YoutubeDAO;
import com.ipartek.formacion.model.pojo.Youtube;



/**
 * Servlet implementation class VideoController
 */
@WebServlet("/videos")
public class YoutubeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_INDEX = "backoffice/youtube/index.jsp";
	public static final String VIEW_FORM  = "backoffice/youtube/formulario.jsp";
	public static final String VIEW_DETALLE  = "backoffice/youtube/detalle.jsp";
	public static String view  = VIEW_INDEX;
		
	
	
	public static final String OP_LISTAR = "0";
	public static final String OP_GUARDAR = "23";
	public static final String OP_BORRAR = "4";
	public static final String OP_ELIMINAR = "hfd3";
	public static final String OP_DETALLE = "13";
	
	public static final String OP_FORM = "1";
	public static final String OP_EDITAR = "2";
	
	private static YoutubeDAO youtubeDAO;
	private static String op;
	
	ValidatorFactory factory;
	Validator validator;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		youtubeDAO = YoutubeDAO.getInstance(); 
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doProcess(request, response);			
	}
	


	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		op = request.getParameter("op");
		if ( op == null ) {
			op = OP_LISTAR;	
		}
		
		switch (op) {
		//lista todos
		case OP_LISTAR:
			listar(request,response);
			break;
		//estos llaman al formulario	
		case OP_FORM: //llama al formulario para crear nuevo o modificar
			detalle(request, response);
			break;
		case OP_BORRAR: //llama al formulario de borrar
			detalle(request, response);
			break;
		case OP_DETALLE: //cargara el video entero
			detalle(request, response);
			break;
		//los que hacen las acciones dentro del formulario
		case OP_GUARDAR:
			guardar(request, response);
			break;
		case OP_ELIMINAR:
			eliminar(request, response);
			break;
		default:
			listar(request, response);
			break;
		}
		
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("videos", youtubeDAO.getAll() );
		view = VIEW_INDEX;
	}
	

	
	private void detalle(HttpServletRequest request, HttpServletResponse response){	
		if(request.getParameter("id") != null) {
			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);
			
			Youtube v = youtubeDAO.getById(id);
			request.setAttribute("video", v );
			request.setAttribute("op", op);
		}else {
			request.setAttribute("video", new Youtube());
			request.setAttribute("op", op);
		}
		
		if(op.equals(OP_DETALLE)) {
			view= VIEW_DETALLE;
		}else {
			view = VIEW_FORM;
		}	
	}	
	

	private void eliminar(HttpServletRequest request, HttpServletResponse response){
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		if ( youtubeDAO.eliminar(id) ) {
			request.setAttribute("mensaje", new Alert("success","Registro Eliminado"));
		}else {
			request.setAttribute("mensaje", new Alert("danger","ERROR, no se pudo eliminar"));
		}
		
		listar(request, response);	
	}
	

	private void guardar(HttpServletRequest request, HttpServletResponse response){
		String sid = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String codigo = request.getParameter("codigo");
		
		Youtube v = new Youtube();
		v.setId(Integer.parseInt(sid));
		v.setNombre(nombre);
		v.setCodigo(codigo);
		
		Set<ConstraintViolation<Youtube>> violations = validator.validate(v);
		if (violations.isEmpty()){ //no hay violations de las validaciones, esta todo bien
			//llama al DAO
			//   si id == -1 => INSERT
			//   si id > 0   => UPDATE
			
			try {
				if ( v.getId() == -1 ) {			
					youtubeDAO.crear(v);
					listar(request, response);
				}else {
					youtubeDAO.modificar(v);
					listar(request, response);
				}
				request.setAttribute("mensaje", new Alert("success","Registro creado con exito"));
				
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensaje", new Alert("danger","Tenemos un problema " + e.getMessage() ));
			}	
			
			request.setAttribute("video", v );
			
		}else { //hay violaciones de las validaciones
			request.setAttribute("mensaje", new Alert("warning", "Datos incorrectos"));
		}
		
		String mensaje ="";
		 for (ConstraintViolation<Youtube> violation : violations) {
			//+= es para que guarde varios mensajes y no los pise
			mensaje+= violation.getPropertyPath()+":"+ violation.getMessage()+"<br>"; 
		 }		
		 request.setAttribute("mensaje", new Alert("warning",mensaje));
	}	
}