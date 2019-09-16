package com.ipartek.formacion.model.pojo;

import java.util.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasenya;
	private Rol rol;
	private Date fechaCreacion;
	private Date fechaEliminacion;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasenya = "";
		this.rol = new Rol();
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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

	public Usuario(int id, String nombre, String contrasenya, Rol rol, Date fechaCreacion, Date fechaEliminacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.rol = rol;
		this.fechaCreacion = fechaCreacion;
		this.fechaEliminacion = fechaEliminacion;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + ", rol=" + rol
				+ ", fechaCreacion=" + fechaCreacion + ", fechaEliminacion=" + fechaEliminacion + "]";
	}

}
