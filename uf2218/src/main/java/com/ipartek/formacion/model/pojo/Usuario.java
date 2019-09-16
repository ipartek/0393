package com.ipartek.formacion.model.pojo;

import java.util.Date;

public class Usuario {

	// Atributos
	private int id;
	private String nombre;
	private String contrasenya;
	private Rol rol;
	private Date fCreacion;
	private Date fBaja;

	// Constructores
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasenya = "";
		this.rol = null;
		this.fCreacion = null;
		this.fBaja = null;
	}

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(int pId, String pNombre, String pContrasenya, Rol pRol, Date pFechaCreacion, Date pFechaBaja) {
		super();
		setId(pId);
		setNombre(pNombre);
		setContrasenya(pContrasenya);
		setRol(pRol);
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + ", idRol=" + rol
				+ ", fCreacion=" + fCreacion + ", fBaja=" + fBaja + "]";
	}
}