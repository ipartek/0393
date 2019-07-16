package com.ipartek.formacion.exception;

import java.util.Scanner;

public class SumarNumeros {

	public static void main(String[] args) {
		
		boolean repetir = false;
		int num1 = 0;
		int num2 = 0;		
		Scanner sc = new Scanner(System.in);		
		
		do {   // repeticion de 1 a N
			
			System.out.println("Introduce 1º numero");
			
			try {
				num1 = Integer.parseInt( sc.nextLine() );
				repetir = false;
				
			}catch (Exception e) {
				System.out.println("** por favor introduce un numero valido");
				repetir = true;
			}	
			
			
		} while (repetir);
		
		
		do {   // repeticion de 1 a N
			
			System.out.println("Introduce 2º numero");
			
			try {
				num2 = Integer.parseInt( sc.nextLine() );
				repetir = false;
				
			}catch (Exception e) {
				System.out.println("** por favor introduce un numero valido");
				repetir = true;
			}	
			
			
		} while (repetir);
		
		
		
		System.out.println( num1 + " + " + num2 + " = " + (num1+num2) );
		
		sc.close();
		

	}

}
