package com.ipartek.formacion.exception;

import com.ipartek.formacion.Perro;

public class PropagacionException {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Comienza Main");
		metodoA();
		System.out.println("Termina Main");
	}
	
	
	private static void metodoA() throws Exception {
		System.out.println("Comienza Metodo A");
	
		Perro p = new Perro();
		p.setEdad(-1);
	
		System.out.println(p);
		
		System.out.println("Termina Metodo A");
	}
	
	
	

}
