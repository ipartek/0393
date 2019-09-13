package com.ipartek.formacion.model.pojo;

import java.util.Date;

public class Usuario {

	// Atributos
	private int id;
	private String nombre;
	private String contrasenya;
	private int idRol;
	private Date fCreacion;
	private Date fBaja;

	// Constructores
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasenya = "";
		this.idRol = 2;
		this.fCreacion = null;
		this.fBaja = null;
	}

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(int pId, String pNombre, String pContrasenya, int pIdRol, Date pFechaCreacion, Date pFechaBaja) {
		super();
		setId(pId);
		setNombre(pNombre);
		setContrasenya(pContrasenya);
		setIdRol(pIdRol);
		setfCreacion(pFechaCreacion);
		setfBaja(pFechaBaja);
	}

	// Getters & Setters
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

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public Date getfCreacion() {
		return fCreacion;
	}

	public void setfCreacion(Date fCreacion) {
		this.fCreacion = fCreacion;
	}

	public Date getfBaja() {
		return fBaja;
	}

	public void setfBaja(Date fBaja) {
		this.fBaja = fBaja;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + ", idRol=" + idRol
				+ ", fCreacion=" + fCreacion + ", fBaja=" + fBaja + "]";
	}
}