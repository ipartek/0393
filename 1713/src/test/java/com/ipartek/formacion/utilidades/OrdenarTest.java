package com.ipartek.formacion.utilidades;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrdenarTest {

	@Test
	public void testBubbleShort() throws Exception {

		int[] aDesordenados = {3,2,1};
		int[] aResultado    = {1,2,3};		
		int[] aOrdenados = Ordenar.bubbleShort(aDesordenados);		
		assertArrayEquals("todos positivos", aResultado, aOrdenados);
		
		
		aDesordenados = new int[] {3,3,3};
		aResultado    = new int[] {3,3,3};		
		aOrdenados = Ordenar.bubbleShort(aDesordenados);		
		assertArrayEquals("Todos iguales", aResultado, aOrdenados);
		
		
		aDesordenados = new int[] {3,0,-3};
		aResultado    = new int[] {-3,0,3};		
		aOrdenados = Ordenar.bubbleShort(aDesordenados);		
		assertArrayEquals("Valores negativos", aResultado, aOrdenados);
		
		aDesordenados = new int[] {3,3,1};
		aResultado    = new int[] {1,3,3};		
		aOrdenados = Ordenar.bubbleShort(aDesordenados);		
		assertArrayEquals("Todos iguales y uno diferente", aResultado, aOrdenados);
		
		
	}
	
	@Test( expected = Exception.class )
	public void testBubbleShortNull() throws Exception {
		
		Ordenar.bubbleShort(null);

	}

}
