package com.ipartek.formacion.utilidades;

public class Ordenar {
	
	
	/**
	 * Ordena de menor a mayor el array
	 * @param aDesordenados int[] con numeros desordenados
	 * @throws Excepcion si aDesordenados == null
	 * @return int[] ordenado de menor a mayor
	 * 
	 */
	public static int[] bubbleShort( int[] aDesordenados ) throws Exception {
		
		if ( aDesordenados == null ) {
			throw new Exception("No puede ser null");
		}
		
		int aux = 0;
		
		for (int i = 0; i < aDesordenados.length; i++) {			
			for (int j = 1; j < aDesordenados.length; j++) {			
				  if(aDesordenados[j-1] > aDesordenados[j]){  
                      //swap elements  
                      aux = aDesordenados[j-1];  
                      aDesordenados[j-1] = aDesordenados[j];  
                      aDesordenados[j] = aux;  
              }  				
			}			
		}
		
		return aDesordenados;
	}
	

	

}
