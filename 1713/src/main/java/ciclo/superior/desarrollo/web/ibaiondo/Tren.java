package ciclo.superior.desarrollo.web.ibaiondo;

public class Tren {
	
	public static final int CAPACIDAD_MAXIMA = 400;
	public static final int EDAD_MAXIMA = 40;
	
	private String tipo;
	private String referencia;
	private int asientosOcupados;
	private int anyosActivo;
	
	
	public Tren(String tipo, String referencia, int asientosOcupados, int anyosActivo) {
		super();
		this.tipo = tipo;
		this.referencia = referencia;
		this.asientosOcupados = asientosOcupados;
		this.anyosActivo = anyosActivo;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public int getAsientosOcupados() {
		return asientosOcupados;
	}


	public void setAsientosOcupados(int asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}


	public int getAnyosActivo() {
		return anyosActivo;
	}


	public void setAnyosActivo(int anyosActivo) {
		this.anyosActivo = anyosActivo;
	}


	
	public String mostrarDatos() {
		return "Tren [tipo=" + tipo + ", referencia=" + referencia + ", asientosOcupados=" + asientosOcupados
				+ ", anyosActivo=" + anyosActivo + "]";
	}
	
	/**
	 * Comprueba la capacidad MAxima
	 * 
	 * @see CAPACIDAD_MAXIMA
	 * @return true si es igual o excende de la CAPACIDAD_MAXIMA, false en caso contrario
	 */
	public boolean estaLleno() {
		
		boolean resul = false;
		
		if ( this.asientosOcupados >= CAPACIDAD_MAXIMA ) {
			resul = true;
		}
		return resul;
	}
	
	
	
	public boolean esViejo() {
		
		boolean resul = false;
		
		if ( this.anyosActivo >= EDAD_MAXIMA ) {
			resul = true;
		}
		return resul;
	}
	
	

}
