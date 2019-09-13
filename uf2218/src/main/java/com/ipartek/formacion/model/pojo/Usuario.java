package com.ipartek.formacion.model.pojo;

import java.util.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasenya;
	private Rol rol;
	private Date fecha_creacion;
	private Date fecha_eliminacion;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasenya = "";
		this.fecha_creacion = new Date();
		this.fecha_eliminacion= null;
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

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_eliminacion() {
		return fecha_eliminacion;
	}

	public void setFecha_eliminacion(Date fecha_eliminacion) {
		this.fecha_eliminacion = fecha_eliminacion;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + ", rol=" + rol
				+ ", fecha_creacion=" + fecha_creacion + ", fecha_eliminacion=" + fecha_eliminacion + "]";
	}



	
	
	
}
