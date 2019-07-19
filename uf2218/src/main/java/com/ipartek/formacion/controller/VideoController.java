package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.dao.VideoDAO;
import com.ipartek.formacion.model.pojo.Video;

/**
 * Servlet implementation class VideoController
 */
@WebServlet("/videos")
public class VideoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_INDEX = "youtube/index.jsp";
	public static final String VIEW_FORM  = "youtube/formulario.jsp";
	public static String view  = VIEW_INDEX;
		
	public static final String OP_LISTAR = "0";
	public static final String OP_DETALLE = "13";
	
	private static VideoDAO videoDAO;
	
       
  
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		videoDAO = VideoDAO.getInstance(); 
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
	
	protected void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		if ( op == null ) {
			op = OP_LISTAR;	
		}
		
		switch (op) {
		case OP_DETALLE:
			detalle(request, response);
			break;

		// TODO resto de metodos	
			
		default:
			listar(request, response);
			break;
		}
		
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("videos", videoDAO.getAll() );
		view = VIEW_INDEX;
		
	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Video v = videoDAO.getById(id);
		request.setAttribute("video", v );
		view = VIEW_FORM;
		
	}



}
