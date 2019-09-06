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
	private Categoria categoria;

	public Video() {
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
		return "Youtube [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + " , usuario=" + usuario
				+ ", categoria=" + categoria + "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = new Usuario();
		;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
