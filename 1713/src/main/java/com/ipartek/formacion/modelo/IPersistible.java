package com.ipartek.formacion.modelo;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Operaciones Basicas de CRUD para Pojos
 * 
 * @author ur00
 *
 */
public interface IPersistible<P> {
		
	/**
	 * listado de P
	 * @return List<P>, si no hay datos lista inicializada
	 */
	List<P> getAll();

	/**
	 * Recupera P por su identificador
	 * @param id int identificador
	 * @return P , si no existe null 
	 */
	P getById(int id);

	
	/**
	 * Crea un nuevo registro
	 * @param pojo
	 * @return true si inserta, false en caso contrario
	 */
	boolean insert(P pojo);

	/**
	 * Elimina un nuevo registro
	 * @param id identificador
	 * @return true si inserta, false en caso contrario
	 */
	boolean delete(int id);

	
	/**
	 * Modifica un nuevo registro
	 * @param pojo
	 * @return true si inserta, false en caso contrario
	 */
	boolean update(P pojo);

}
