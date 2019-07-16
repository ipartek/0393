package com.ipartek.formacion.modelo.pojo;

import java.io.Serializable;

public class Perro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;

	private String raza;

	private int edad;

	private boolean vacunado;

	// constructor

	public Perro() {

		super();
		this.nombre = "Sin Nombre";
		this.raza = "Cruce";
		this.edad = 0;
		this.vacunado = false;

	}

	public Perro(String nombre) {
		this();
		// super();
		this.nombre = nombre;
	}

	public Perro(String nombre, int edad) throws Exception {
		this();
		this.nombre = nombre;
		// this.edad = edad;
		this.setEdad(edad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isVacunado() {
		return vacunado;
	}

	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", vacunado=" + vacunado + "]";
	}

}
