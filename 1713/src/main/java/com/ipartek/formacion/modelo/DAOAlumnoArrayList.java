package com.ipartek.formacion.modelo;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.Alumno;

public class DAOAlumnoArrayList implements IPersistible<Alumno> {

	private static DAOAlumnoArrayList INSTANCE;
	private ArrayList<Alumno> lista;
	
	/**
	 * Encargado de devolver solo 1 objeto, patron Singleton	
	 * @return
	 */
	public static synchronized DAOAlumnoArrayList getInstance(){
		
		if ( INSTANCE == null ) {
			INSTANCE = new DAOAlumnoArrayList();
		}
		
		return INSTANCE;
		
	}
	
	/**
	 * Privado para que nadie pueda crear objetos
	 */
	private DAOAlumnoArrayList() {
		super();
		lista = new ArrayList<Alumno>();			
	}


	@Override
	public List<Alumno> getAll() {		
		return lista;
	}

	@Override
	public Alumno getById(int id) {
		Alumno resul = null;
		for (Alumno a: lista) {
			
			if ( a.getId() == id ) {
				resul = a;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Alumno pojo) {
		boolean resul = false;
		if ( pojo != null ) {
			resul = lista.add(pojo);
		}
		return resul;
	}

	@Override
	public boolean delete(int id) {
		
		Alumno a = getById(id);	
		
		return lista.remove(a);
	}

	@Override
	public boolean update(Alumno pojo) {
		boolean resul = false; 
		
		if ( pojo != null ) {
		
			for (Alumno a: lista) {
				
				if ( a.getId() == pojo.getId() ) {
					//modificar
					int pos = lista.indexOf(a);
					lista.set( pos , pojo);
					resul = true;
					break;
				}
			}
		}	
		
		
		return resul;
	}

}
