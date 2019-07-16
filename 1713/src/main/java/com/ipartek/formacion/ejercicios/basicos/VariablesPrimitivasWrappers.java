package com.ipartek.formacion.ejercicios.basicos;

import java.util.Scanner;

/**
 * @see: http://www.campus.formacion.ipartek.com/moodle/mod/page/view.php?id=882
 * @author ur00
 *
 */
public class VariablesPrimitivasWrappers {

		
	public static void main(String[] args) {
		
		// declarar todas los posibles tipos variables primitivas
		
		// numero enteros
		byte b = 5;
		short s = 4;
		int i = 0;
		long l = 8;
		
		//numero reales
		float f = 2.34f;
		double d = 4.56;
		
		char c = 'a';  // comillas simples
		
		boolean b1 = true; // or false
		
		
		// Wrappers
		
		int numeroParseado = Integer.parseInt("3");
		
		
		System.out.printf("EL rango de un int %d %d \n \n \n", Integer.MIN_VALUE , Integer.MAX_VALUE );
		
		
		// indicar si el caracter introducido por pantalla es
		// mayusculas o minusculas
		// letra o numero
		
		System.out.println("Por favor introcude un carcater");
		
		Scanner sc = new Scanner(System.in);
		
		char caracter = sc.next().charAt(0);
		
		System.out.println( Character.isLetter(caracter) ? " Es Letra": " No es Letra");
		System.out.println( Character.isDigit(caracter) ? " Es Numero": " No es Numero");
		System.out.println( Character.isLowerCase(caracter) ? " Es minuscula": " No es minuscula");
		System.out.println( Character.isUpperCase(caracter) ? " Es Mayuscula": " No es Mayuscula");
		System.out.println( Character.isLetterOrDigit(caracter) ? "" : "**Es caracter especial");
		System.out.println( Character.isWhitespace(caracter) ? "" : "**Espacio vacio");
		
		
		sc.close();
		
		
		
		
	}
	
}
