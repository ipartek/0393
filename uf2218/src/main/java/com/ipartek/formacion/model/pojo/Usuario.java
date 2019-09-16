package com.ipartek.formacion.model.pojo;

import java.util.Date;

public class Usuario {

	//atributos
	private int id;
	private String nombre;
	private String contrasenya;
	private Date fechaCreacion;
	private Date fechaEliminacion;
	private Rol rol;
	
	//contructores
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasenya = "";
		this.fechaCreacion = null;
		this.fechaEliminacion = null;
		this.rol = new Rol();
	}

	public Usuario(int id, String nombre, String contrasenya, Date fechaCreacion, Date fechaEliminacion, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.fechaCreacion = fechaCreacion;
		this.fechaEliminacion = fechaEliminacion;
		this.rol = rol;
	}
	
	//getters y setters
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + ", fechaCreacion="
				+ fechaCreacion + ", fechaEliminacion=" + fechaEliminacion + ", rol=" + rol + "]";
	}
	
}