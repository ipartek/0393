import com.ipartek.formacion.Perro;
import com.ipartek.formacion.PerroPresa;
import com.ipartek.formacion.Person;

public class HelloWorld {

	public static void main(String[] args) throws Exception {	
		
	 
		String nombre = "Ander";
		
		System.out.println("  Hello  " + nombre );
		
		
		Person p1 = new Person();
		p1.setNombre("Manolo");
		
		System.out.println(  p1.toString()  );
		
		
		Perro p2 = new Perro("Rataplam");
		System.out.println( p2 );
		
		
		Perro pulgas = new Perro();
		
		pulgas.setNombre("Pulgas");
		pulgas.setEdad(-2);
		
		System.out.println( pulgas.toString() );
		
		
		PerroPresa buba = new PerroPresa();
		buba.setNombre("Buba");
		buba.atacar();
		
		
		
		
		
	}

}
