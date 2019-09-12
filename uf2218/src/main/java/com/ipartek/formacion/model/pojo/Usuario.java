package com.ipartek.formacion.model.pojo;

import java.sql.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String contra;
	private Date fecha_creacion;
	private Date fecha_eliminacion;
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

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contra=" + contra + ", fecha_creacion=" + fecha_creacion
				+ ", fecha_eliminacion=" + fecha_eliminacion + ", id_rol=" + id_rol + "]";
	}

}
