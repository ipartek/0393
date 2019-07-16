package ciclo.superior.desarrollo.web.ibaiondo;

import java.util.Scanner;

public class Ejercicio3 {

	final static int MAX_NUMEROS = 10;
	static int[] aNumeros = new int[MAX_NUMEROS];
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		float sumatorio = 0;

		for (int i = 0; i < MAX_NUMEROS; i++) {

			System.out.println("Dime numero numero " + (i+1) );

			int numero = Integer.parseInt(sc.nextLine());
			
			aNumeros[i] = numero;
			
			if ( numero % 7 == 0 ) {
				System.out.println("Es multiplo del 7");
			}
			
			sumatorio += numero;
			

		} // end for

		float media = sumatorio / MAX_NUMEROS;		
		System.out.printf("Terminamos Media %.2f " ,media );

		sc.close();

	}

}
