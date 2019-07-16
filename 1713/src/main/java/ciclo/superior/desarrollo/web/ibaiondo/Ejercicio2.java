package ciclo.superior.desarrollo.web.ibaiondo;

import java.util.Scanner;

public class Ejercicio2 {

	/**
	 * funcion que calcula si el jugador tiene posibilidades de ganar
	 * 
	 * @param puntos int puntos de la clasificacion
	 * @return true si puntos >= 70, else false
	 */
	private static boolean ganar(int puntos) {

		boolean resul = false;

		if (puntos >= 70) {
			resul = true;
		}

		return resul;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Dime tus puntos:");
		int puntos = Integer.parseInt(sc.nextLine());

		if (ganar(puntos)) {
			System.out.println("Eres un campeon");
		} else {
			System.out.println("Trata de arancarlo por dios carlos!!!!!!!!!");
		}

		sc.close();

	}

}
