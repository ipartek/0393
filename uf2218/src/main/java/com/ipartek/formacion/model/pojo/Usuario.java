package com.ipartek.formacion.model.pojo;

import java.sql.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasena;
	private int rol;
	private Date fecha_creacion;
	private Date fecha_eliminacion;	

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasena = "";
		this.fecha_creacion = null;
		this.fecha_eliminacion = null;
		this.setRol(-1);
		
	}

	public Date getFecha_eliminacion() {
		return fecha_eliminacion;
	}

	public void setFecha_eliminacion(Date fecha_eliminacion) {
		this.fecha_eliminacion = fecha_eliminacion;
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
				+ ", fecha_creacion=" + fecha_creacion + ", fecha_eliminacion=" + fecha_eliminacion + "]";
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	
	
	

}
