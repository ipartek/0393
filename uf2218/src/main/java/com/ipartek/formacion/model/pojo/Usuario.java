package com.ipartek.formacion.model.pojo;

import java.util.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasena;
	private int rol;
	private Date fechaCreacion;
	private Date fechaEliminacion;	

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasena = "";
		this.fechaCreacion = null;
		this.fechaEliminacion = null;
		this.setRol(-1);
		
	}

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
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
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", rol=" + rol
				+ ", fechaCreacion=" + fechaCreacion + ", fechaEliminacion=" + fechaEliminacion + "]";
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	
	
	

}
