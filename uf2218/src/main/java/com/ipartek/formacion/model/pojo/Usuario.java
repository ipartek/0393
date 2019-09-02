package com.ipartek.formacion.model.pojo;

public class Usuario {

	
	private int id;
	private String nombre;
	private String contrasenya;
	
	
	
	public Usuario() {
		super();

		this.id= -1;
		this.nombre= "";
		this.contrasenya= "";
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



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + "]";
	}
	
	
	
}
