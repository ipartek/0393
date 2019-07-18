package com.ipartek.formacion.model.pojo;

public class Youtube {
	private int id;
	private String nombre;
	private String codigo;

	public Youtube() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = "";
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Youtube [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}

}
