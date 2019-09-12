package com.ipartek.formacion.model.pojo;

public class Usuario {

	// Atributos
	private int id;
	private String nombre;
	private String contrasenya;
	private int idRol;
	private String fCreacion;
	private String fBaja;

	// Constructores
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.contrasenya = "";
		this.idRol = 2;
		this.fCreacion = "";
		this.fBaja = "";
	}

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(int pId, String pNombre, String pContrasenya, int pIdRol, String pFechaCreacion,
			String pFechaEliminacion) {
		super();
		setId(pId);
		setNombre(pNombre);
		setContrasenya(pContrasenya);
		setIdRol(pIdRol);
		setfCreacion(pFechaCreacion);
		setfBaja(pFechaEliminacion);
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

	public String getfCreacion() {
		return fCreacion;
	}

	public void setfCreacion(String fCreacion) {
		this.fCreacion = fCreacion;
	}

	public String getfBaja() {
		return fBaja;
	}

	public void setfBaja(String fBaja) {
		this.fBaja = fBaja;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + ", idRol=" + idRol
				+ ", fCreacion=" + fCreacion + ", fBaja=" + fBaja + "]";
	}
}