package com.ipartek.formacion.utilidades;

public class CalculadoraDevolucion {

	public static final float[] BILLETES_MONEDAS = {
			// billetes
			500, 200, 100, 50, 20, 10, 5,
			// monedas
			2, 1, 0.50f, 0.20f, 0.10f, 0.05f, 0.02f, 0.01f };

	/**
	 * Calcula las vueltas optimas para retornar el menor numero de billetes y monedas	
	 * @param importe float costo del articulo a comprar
	 * @param entregado float dinero entrega para comprar
	 * @return int[] cantidad de billetes y monedas retornadas
	 * @see public static final float[] BILLETES_MONEDAS
	 * @throws Exception importe > entregado o si importe < 0 o entregado < 0
	 */
	public static int[] vueltas(float importe, float entregado) throws Exception {

		if ( importe > entregado ) {
			throw new Exception("No seas rata y dame dinero");
		} 
		
		if ( importe < 0 || entregado < 0 ) {
			throw new Exception("tiene que ser mayor que cero");
		}
		
		int[] resul = new int[BILLETES_MONEDAS.length];		
		float resto = entregado - importe;
		
		if ( resto > 0) {
			
			for (int i = 0; i < BILLETES_MONEDAS.length; i++) {
			
				resul[i] = (int) (resto / BILLETES_MONEDAS[i]);
				resto = resto % BILLETES_MONEDAS[i];
				//redonderar a 2 decimales, porque los float pierden 
				resto = Math.round(resto * 100.0f) / 100.0f;
				
			}			
			
		}
		
		return resul;
	}

}
