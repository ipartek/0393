package com.ipartek.formacion.utilidades;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

public class CalculadoraTest {

	@Test	
	public void sumar() {
	
		int resultado = Calculadora.sumar(2, 3);
		assertEquals("No suma bien", 5 , resultado  );
		
	}
	
	@Test	
	public void restar() {
		
		assertEquals( 0 , Calculadora.restar(2, 2) );
		assertEquals( -1 , Calculadora.restar(2, 3) );
		assertEquals( 1 , Calculadora.restar( 3, 2) );
		
	}
	
	
	@Test	
	public void multiplicar() {
		
		assertEquals( 4 , Calculadora.multiplicar(2, 2) );
		assertEquals( 0 , Calculadora.multiplicar(2, 0) );
		assertEquals( 0 , Calculadora.multiplicar(0, 2) );
		assertEquals( -4 , Calculadora.multiplicar(2, -2) );
		
	}
	
	@Test( expected = ArithmeticException.class)	
	public void dividir() {
		
		assertEquals( 2 , Calculadora.dividir(5, 2) );
		assertEquals( 0 , Calculadora.dividir(0, 2) );
		assertEquals( 5 , Calculadora.dividir(10, 2) );
		assertEquals( -5 , Calculadora.dividir(10, -2) );
		
		
		Calculadora.dividir(2, 0);
				
		
	}
	
	@Test( expected = NullPointerException.class)	
	public void dividirNullPointer() {
		
	}

}
