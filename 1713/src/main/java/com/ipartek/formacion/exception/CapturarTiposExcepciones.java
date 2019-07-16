package com.ipartek.formacion.exception;

import com.ipartek.formacion.Perro;
import com.ipartek.formacion.PerroException;

/**
 * Se pueden capturar mas de un tipo de Excepciones.
 * Siempre la ultima en capturar que sea Exception, que es la mas generica
 * 
 * @author ur00
 *
 */
public class CapturarTiposExcepciones {
	
	

	public static void main(String[] args) {
		
		
		try {			
			//Perro p = null;
			Perro p = new Perro();
			p.setEdad(-1);
			p.toString();
			System.out.println(p);
		
		} catch (ArrayIndexOutOfBoundsException e) {	
			System.out.println("Se has salido fuera del Array");
		} catch (PerroException e) {	
			System.out.println("PerroExcepcion Null");
		} catch (NullPointerException e) {	
			System.out.println("Excepcion Null");			
		} catch (Exception e) {
			System.out.println("Excepcion Generica, siempre la ultima");
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
