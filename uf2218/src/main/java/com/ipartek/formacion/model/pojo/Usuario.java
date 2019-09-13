package com.ipartek.formacion.model.pojo;

import java.sql.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String contra;
	private Date fechaCreacion;
	private Date fechaEliminacion;
	private int id_rol;

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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fecha_creacion) {
		this.fechaCreacion = fecha_creacion;
	}

	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(Date fecha_eliminacion) {
		this.fechaEliminacion = fecha_eliminacion;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contra=" + contra + ", fechaCreacion=" + fechaCreacion
				+ ", fechaEliminacion=" + fechaEliminacion + ", id_rol=" + id_rol + "]";
	}

}
