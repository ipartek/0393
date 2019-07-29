package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet implementation class CalculadoraController
 */
@WebServlet("/calculadora")
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_INDEX = "calculadora/index.jsp";
	public static String view = VIEW_INDEX;
    
	public static final String OP_SUMAR = "sumar";
	public static final String OP_RESTAR = "restar";
	public static final String OP_MULTIPLICAR = "multiplicar";
	public static final String OP_DIVIDIR = "dividir";
	
	private static double numero1;
	private static double numero2;
	private Double resultado;
	private static String op;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculadoraController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		op = request.getParameter("op");
		/*
		if (op == null) {
			request.setAttribute("mensaje", new Alert("warning", "Selecciona una operación"));
		}
		*/
		switch (op) {
		case OP_SUMAR:
			sumar(request, response);
			break;
		case OP_RESTAR: 
			restar(request, response);
			break;
		case OP_MULTIPLICAR:
			multiplicar(request, response);
			break;
		case OP_DIVIDIR: 
			dividir(request, response);
			break;
		default:
			request.setAttribute("mensaje", new Alert("warning", "Por favor selecciona una operación"));
			break;
		}
		
		request.setAttribute("op", op);
		request.getRequestDispatcher(view).forward(request, response);

	}

	private void sumar(HttpServletRequest request, HttpServletResponse response) {
		numero1=0.0;
		numero2=0.0;
		resultado =0.0;
		String datoNum1= request.getParameter("numero1");
		String datoNum2= request.getParameter("numero2");
		try {
			if(!datoNum1.isEmpty()) {
				numero1 = Double.parseDouble(datoNum1);	
			}
			if(!datoNum2.isEmpty()) {	
				numero2 = Double.parseDouble(datoNum2);	
			}	
		
		} catch (NumberFormatException e) {
			numero1=0.0;
			numero2=0.0;
			resultado = 0.0;
			request.setAttribute("mensaje", new Alert("warning", "Has introducido una valor no valido"));
			
		}finally {
			resultado= numero1+numero2;
			request.setAttribute("numero1", numero1 );
			request.setAttribute("numero2", numero2 );
			request.setAttribute("resultado", resultado );
		}
	}

	private void restar(HttpServletRequest request, HttpServletResponse response) {
		numero1=0.0;
		numero2=0.0;
		resultado =0.0;
		String datoNum1= request.getParameter("numero1");
		String datoNum2= request.getParameter("numero2");
		
		try {
			if(!datoNum1.isEmpty()) {
				numero1 = Double.parseDouble(datoNum1);	
			}
			if(!datoNum2.isEmpty()) {	
				numero2 = Double.parseDouble(datoNum2);	
			}	
		
		} catch (Exception e) {
			numero1=0.0;
			numero2=0.0;
			resultado = 0.0;
			request.setAttribute("mensaje", new Alert("warning", "Has introducido una valor no valido"));
		}finally {
			resultado= numero1-numero2;
			request.setAttribute("numero1", numero1 );
			request.setAttribute("numero2", numero2 );
			request.setAttribute("resultado", resultado );
		}
	}
	
	private void multiplicar(HttpServletRequest request, HttpServletResponse response) {
		numero1=0.0;
		numero2=0.0;
		resultado =0.0;
		String datoNum1= request.getParameter("numero1");
		String datoNum2= request.getParameter("numero2");
		
		try {
			if(!datoNum1.isEmpty()) {
				numero1 = Double.parseDouble(datoNum1);	
			}
			if(!datoNum2.isEmpty()) {	
				numero2 = Double.parseDouble(datoNum2);	
			}	
		
		} catch (Exception e) {
			numero1=0.0;
			numero2=0.0;
			resultado = 0.0;
			request.setAttribute("mensaje", new Alert("warning", "Has introducido una valor no valido"));
			
		}finally {
			resultado= numero1*numero2;
			request.setAttribute("numero1", numero1 );
			request.setAttribute("numero2", numero2 );
			request.setAttribute("resultado", resultado );
		}
	}
	
	private void dividir(HttpServletRequest request, HttpServletResponse response) {
		numero1=0.0;
		numero2=0.0;
		resultado =0.0;
		String datoNum1= request.getParameter("numero1");
		String datoNum2= request.getParameter("numero2");
		try {
			if(!datoNum1.isEmpty()) {
				numero1 = Double.parseDouble(datoNum1);	
			}
			if (!datoNum1.equals("0.0")&& datoNum2.equals("0.0")) {
				numero1=0.0;
				numero2=0.0;
				resultado =0.0;
				request.setAttribute("mensaje", new Alert("danger","Error no se puede dividir entre 0"));	
			}else{	
				if(!datoNum2.isEmpty()) {	
					numero2 = Double.parseDouble(datoNum2);	
				}
			}	
		
		} catch (Exception e) {
			resultado = 0.0;
			request.setAttribute("mensaje", new Alert("warning", "Has introducido una valor no valido"));
		}
		
		if (!datoNum1.equals("0.0") && !datoNum2.equals("0.0")) {
			resultado= numero1/numero2;
		}else {
			request.setAttribute("mensaje", new Alert("danger","Error no se puede dividir entre 0"));
		}

		request.setAttribute("numero1", numero1 );
		request.setAttribute("numero2", numero2 );
		request.setAttribute("resultado", resultado );		
	}

}
