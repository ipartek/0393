package com.ipartek.formacion.exception;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		System.out.println("Comienza programa");
		
		
		
		System.out.println("Por favor introcude un numero del 0 al 9");
		
		Scanner sc = new Scanner(System.in);
		
		try {
					
			String sNumero = sc.nextLine();   
			int numero = Integer.parseInt(sNumero);					
			System.out.println( "Su numero es " + numero );
				
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Mensaje Excepcion " +  e.getMessage() );
			System.out.println("*** TE DIJE UN NUMERO !!!!! que si no falla");
			
		}finally {	// opcional	
			sc.close();
		}		
		
				
		
		System.out.println("Finaliza programa");

	}

}
