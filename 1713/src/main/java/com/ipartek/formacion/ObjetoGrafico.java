package com.ipartek.formacion;

public abstract class ObjetoGrafico {
	
	// atributos...
	
	// construcotres...
	
	public void mover(int x, int y ) {
		
		System.out.println("Movemos el objeto a su nueva posicion");
		
	}
	
	
	public abstract void dibujar( String color ); // prototipo
	
	

}
