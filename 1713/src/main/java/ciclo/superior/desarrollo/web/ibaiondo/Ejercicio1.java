package ciclo.superior.desarrollo.web.ibaiondo;

import java.util.Scanner;

public class Ejercicio1 {
	
	final static int MAX_BOXEADORES = 30;

	final static int PESO_MOSCA = 52;
	final static int PESO_PLUMA = 57;
	final static int PESO_LIGERO = 65;
	final static int PESO_MEDIANO = 90;
	// > 90 PESADO

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			for (int i = 0; i < MAX_BOXEADORES ; i++) {
				
				
				System.out.println("Dime el peso del boxeador en Kilogramos:");
	
				int peso = Integer.parseInt(sc.nextLine());
	
				if ( peso <= 0) {
					throw new Exception("Peso incorrecto, debe ser > 0");
				} 
				
				if (peso < PESO_MOSCA) {
					System.out.println("Mosca");
					
				} else if (peso < PESO_PLUMA) {
					System.out.println("Pluma");
					
				} else if (peso < PESO_LIGERO) {
					System.out.println("Ligero");
					
				} else if (peso < PESO_MEDIANO) {
					System.out.println("Mediano");
					
				} else {
					System.out.println("Pesado");
				}
				
			} // end for	
			
			System.out.println("Terminamos");

		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Capturada Exception y terminamos");
		}finally {
			sc.close();	
		}

		

	}

}
