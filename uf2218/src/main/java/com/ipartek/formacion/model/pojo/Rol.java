package com.ipartek.formacion.model.pojo;

public class Rol {

	public static final int ROL_ADMIN = 1;
	public static final int ROL_USER = 2;
	// Atributos
	private int id;
	private String nombre;

	// Constructores
	public Rol() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Rol(int id) {
		super();
		setId(id);
		if (id == ROL_ADMIN) {
			setNombre("administrador");
		} else if (id == ROL_USER) {
			setNombre("usuario");
		}
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