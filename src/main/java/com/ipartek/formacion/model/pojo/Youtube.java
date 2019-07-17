package com.ipartek.formacion.model.pojo;

public class Youtube {
	public static final int LONGITUD_CODIGO =11;
	public static final int LONGITUD_MIN_TITULO =2;
	public static final int LONGITUD_MAX_TITULO =150;
	public static final String URL="https://www.youtube.com/watch?v=";
	//atributos
	private String titulo;
	private String codigo;
	private int reproducciones;
	
	
	//contructora
	public Youtube(String titulo, String codigo) throws Exception {
		super();
		//this.titulo = titulo; //minimo 2 letras maximo 150
		//this.codigo = codigo;	//exactamente 11
	
		this.setTitulo(titulo);
		this.setCodigo(codigo);
		this.reproducciones=0;
	}
	
	//getters y setters
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Cambia titulo
	 * @param titulo String nuevo titulo
	 * @throws Exception si titulo null || > LONGITUD_MIN_TITULO || > LONGITUD_MAX_TITULO
	 */
	public void setTitulo(String titulo) throws Exception {
		if (titulo!=null && 
			titulo.length()>=LONGITUD_MIN_TITULO && 
			titulo.length()<=LONGITUD_MAX_TITULO) {
				this.titulo = titulo;
		}else {
			String msg =String.format("Titulo debe tener longitud entre "+LONGITUD_MIN_TITULO+" y "+LONGITUD_MAX_TITULO);
			throw new Exception(msg);
		}
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) throws Exception {
		if (codigo!=null && codigo.length()==LONGITUD_CODIGO) {
			this.codigo = codigo;
		}else {
			throw new Exception("Longitud codigo debe ser "+LONGITUD_CODIGO);
		}
			
	}
	public int getReproducciones() {
		return reproducciones;
	}
	public void setReproducciones(int reproducciones) throws Exception {
		if (reproducciones>0) {
			this.reproducciones = reproducciones;
		}else {
			throw new Exception("Reproducciones debe ser >= 0");
		}
		
	}
	
	//metodos
	@Override
	public String toString() {
		return "Youtube [titulo=" + titulo + ", codigo=" + codigo + ", reproducciones=" + reproducciones + "]";
	}
	
	public String getUrl() {
		return URL + codigo;	
	}

}
