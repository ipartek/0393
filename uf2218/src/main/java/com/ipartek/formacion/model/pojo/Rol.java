package com.ipartek.formacion.model.pojo;

public class Rol {
	
	public static final int ROL_ADMIN = 1;
	public static final int ROL_USER = 2;
	
	private int id;
	private String nombre;
	
	public Rol() {
		super();
		this.id = ROL_USER;
		this.nombre = "usuario";
	}

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
