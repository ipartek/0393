package com.ipartek.formacion.model.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Video {

	private int id;

	@NotNull
	@Size(min = 3, max = 150)
	private String nombre;

	@NotNull
	@Size(min = 11, max = 11, message = "Exactamente debe ser 11")
	private String codigo;

	private Usuario usuario;

	public Video() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = "";
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", usuario=" + usuario + "]";
	}

}
