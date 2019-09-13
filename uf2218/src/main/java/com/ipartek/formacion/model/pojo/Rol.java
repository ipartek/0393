package com.ipartek.formacion.model.pojo;

public class Rol {

	// Atributos
	private int id;
	private String nombre;

	// Constructores
	public Rol() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Rol(int id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
}