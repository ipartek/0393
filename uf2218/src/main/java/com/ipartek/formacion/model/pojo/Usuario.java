package com.ipartek.formacion.model.pojo;

public class Usuario {

	private int id;
	private String nombre;
	private String contra;

	public Usuario(int id, String nombre, String contra) {
		super();
		this.id = -1;
		this.nombre = "";
		this.contra = "";
	}

	public Usuario() {
		super();
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

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contra=" + contra + "]";
	}

}
