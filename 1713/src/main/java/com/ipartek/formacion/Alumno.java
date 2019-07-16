package com.ipartek.formacion;

import java.io.Serializable;

public class Alumno extends Person implements Comparable<Alumno>, IAmigable, Serializable{


	private static final long serialVersionUID = 1L;
	
	private int numVecesLeer;
	
	
	public Alumno(int id, String nombre) {
		super(nombre);
		super.setId(id);
		this.numVecesLeer = 0;
	}

	public int getNumVecesLeer() {
		return numVecesLeer;
	}

	public void setNumVecesLeer(int numVecesLeer) {
		this.numVecesLeer = numVecesLeer;
	}

	@Override
	public String toString() {
		return super.toString() + "Alumno [numVecesLeer=" + numVecesLeer + "]";
	}

	@Override
	public int compareTo(Alumno o) {		
		return o.getNumVecesLeer() - this.numVecesLeer;
	}

	@Override
	public String despedir() {		
		return "Agur Venur";
	}


	
	
	
}
