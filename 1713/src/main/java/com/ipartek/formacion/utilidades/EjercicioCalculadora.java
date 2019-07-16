package com.ipartek.formacion.utilidades;

import com.ipartek.formacion.Perro;

public class EjercicioCalculadora {

	public static void main(String[] args) {
	
		
		// metodos de instancia u objeto
		Perro p = new Perro();
		p.toString();

		
		// metodos estaticos o de clase, obligatorio que sean 'static'
		
		Math.random();
		
		int resultado = Calculadora.sumar(2,3);
		System.out.println( "2 + 3 = " + resultado );

	}

}
