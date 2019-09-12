package com.ipartek.formacion.model.pojo;

import java.sql.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasena;
	private Date fecha_eliminacion;
	private int rol;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasena = "";
		this.fecha_eliminacion = null;
		this.setRol(0);
	}

	public Date getFecha_eliminacion() {
		return fecha_eliminacion;
	}

	public void setFecha_eliminacion(Date fecha_eliminado) {
		this.fecha_eliminacion = fecha_eliminado;
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
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", fecha_eliminado="
				+ fecha_eliminacion + ", rol=" + rol + "]";
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	
	
	

}
