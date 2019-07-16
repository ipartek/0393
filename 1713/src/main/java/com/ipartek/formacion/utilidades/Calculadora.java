package com.ipartek.formacion.utilidades;

public class Calculadora {

	/**
	 * Suma dos enteros
	 * @param a int sumando 
	 * @param b int sumando
	 * @return a + b
	 */
	public static int sumar(int a, int b) {
		
		return a + b;
		
	}
	
	
	public static int restar(int a, int b) {		
		return a - b;
		
	}
	
	public static int multiplicar(int a, int b) {
		
		return a * b;
		
	}
	
	public static int dividir(int a, int b) throws ArithmeticException{
		
		return a / b;
		
	}
	
	
	
}
