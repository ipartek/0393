package com.ipartek.formacion.model.pojo;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasenya;
	private int rol;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasenya = "";
		this.rol = -1;
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

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public Usuario(int id, String nombre, String contrasenya, int rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.rol = rol;
	}

}
