package com.ipartek.formacion.model.pojo;

public class Usuario {
	
	private int id;
	private String nombre;
	private String contrasena;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasena = "";
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + "]";
	}
	
	

}
