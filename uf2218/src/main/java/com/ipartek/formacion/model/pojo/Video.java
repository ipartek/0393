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

	@NotNull
	private Categoria categoria;

	@NotNull
	private Usuario usuario;

	public Video() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = "";
		this.categoria = new Categoria();
		this.usuario = new Usuario();
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", categoria=" + categoria
				+ ", usuario=" + usuario + "]";
	}
}