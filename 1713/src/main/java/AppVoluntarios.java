import java.util.Collections;
import java.util.Scanner;

import com.ipartek.formacion.Alumno;
import com.ipartek.formacion.modelo.DAOAlumnoArrayList;
import com.ipartek.formacion.modelo.DAOAlumnoSeriablizable;

public class AppVoluntarios {

	final static int  OPCION_LISTAR     = 1;
	final static int  OPCION_CREAR      = 2;
	final static int  OPCION_BORRAR     = 3;
	final static int  OPCION_VOLUNTARIO = 4;
	final static int  OPCION_SALIR      = 0;
	
	static int opcionSeleccionada;
	static Scanner sc;
	//static DAOAlumnoArrayList dao;
	static DAOAlumnoSeriablizable dao;
	static Alumno anterior = new Alumno(-1,""); 
	
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);		
		//dao = DAOAlumnoArrayList.getInstance();
		dao = DAOAlumnoSeriablizable.getInstance();
		
		//mockAlumnos();
				
		do {
		
			pintarMenuYpedirOpcion();
			
			switch (opcionSeleccionada) {
			case OPCION_LISTAR:
				listar();
				break;
				
			case OPCION_BORRAR:
				borrar();
				break;
	
			case OPCION_CREAR:
				crear();
				break;
				
			case OPCION_VOLUNTARIO:
				mostrarVoluntario();
				break;		
				
			default:
				break;
			}
			
		}while(opcionSeleccionada != OPCION_SALIR);
		
		System.out.println("Agur Venur");
		
		
		sc.close();
		

	}

	/*

	private static void mockAlumnos() {
		
		dao.insert(new Alumno(1, "Pepe"));
		dao.insert(new Alumno(12, "Manoli"));
		dao.insert(new Alumno(56, "Juan"));
		dao.insert(new Alumno(7, "Rakel"));
		
	}

	*/

	private static void mostrarVoluntario() {
		
		int numAletario = (int)( Math.random() * dao.getAll().size() );
		
		Alumno a = dao.getAll().get(numAletario);
		
		if ( anterior.getId() != a.getId() ) {
		
		
			a.setNumVecesLeer( 1 + a.getNumVecesLeer() );			
			dao.update(a);
			anterior = a;
			
		}else {
			System.out.println("Vuelve a tirar porque " + a.getNombre() + " ya ha salido antes");
		}	
		
		System.out.println( "Voluntario: " + a.getNombre() );
		
		
	}



	private static void crear() {
		
		try {
		
			//pedir datos por consola
			System.out.println("Dime el NOMBRE:");
			String nombre = sc.nextLine();
			
			System.out.println("Dime el ID:");
			int id = Integer.parseInt(sc.nextLine());
			
			// creamos nuevo alumno
			Alumno nuevoAlumno = new Alumno(id, nombre);
			
			// persistir a traves del dao
			if ( dao.insert(nuevoAlumno) ) {
				
				System.out.println("Alumno creado con Exito !!!!!!!!!!!! ");
				
			}else {
				
				System.out.println("*** ERROR al insertar **** ");
				
			}
		}catch (Exception e) {
			System.out.println("*** DATOS INCORRECTOS, por favor empieza de nuevo *** ");
			crear();
		}	
		
	}



	private static void borrar() {
		System.out.println("Borrar Alumno");
		
	}

	private static void listar() {
		System.out.println("Listado de Alumnos");
		System.out.println("--------------------------------");
		System.out.println("   ID           NOMBRE   NUM.VOLUNTARIO");
		System.out.println("--------------------------------");
		
		Collections.sort(dao.getAll());

		for (Alumno alumno : dao.getAll() ) {
			System.out.printf( " %3s  %15s  %2s \n", alumno.getId(), alumno.getNombre() , alumno.getNumVecesLeer() );
		}
		
		
	}

	private static void pintarMenuYpedirOpcion() {
		
		System.out.println("-------------------------------");
		System.out.println("1 Listar");
		System.out.println("2 Crear");
		System.out.println("3 Eliminar");
		System.out.println("4 Voluntario");		
		System.out.println("-------------------------------");
		System.out.println(" 0 para salir");
		System.out.println("-------------------------------");
		System.out.println("");
		System.out.println("Dime tu opcion.....");
		
		try {
		
			opcionSeleccionada = Integer.parseInt(sc.nextLine());
			
		}catch (Exception e) {
			System.out.println("*** opcion no posible **** ");
			
			pintarMenuYpedirOpcion();
			
		}	
		
	}// pintarMenuYpedirOpcion

}
