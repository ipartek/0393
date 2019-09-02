package com.ipartek.formacion.model.pojo;

import org.apache.pdfbox.contentstream.operator.text.SetCharSpacing;

public class Usuario {
	
	//Atributos
	private int id;
	private String nombre;
	private String contrasenya;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasenya = "";
	}

	public Usuario(int pId, String pNombre, String pContrasenya) {
		super();
		setId(pId);
		setNombre(pNombre);
		setContrasenya(pContrasenya);
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