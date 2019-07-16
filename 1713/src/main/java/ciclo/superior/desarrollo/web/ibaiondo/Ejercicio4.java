package ciclo.superior.desarrollo.web.ibaiondo;


public class Ejercicio4 {
	
	

	public static void main(String[] args) {

		Tren t1 = new Tren("Locomotora", "LOC123", 400, 6);
		
		System.out.println( t1.mostrarDatos() );

		
		if ( t1.estaLleno() ) {
			System.out.println("Esta petadu el tren");
		}else {
			System.out.println("Todavia entramos mas");
		}
		
		if ( t1.esViejo() ) {
			System.out.println("Juvilate");
		}else {
			System.out.println("Sigue currando");
		}
		
	}

}
