package com.ipartek.formacion;

import java.util.Date;

public class Employee extends Person {

	public final float SALARIO_MINIMO = 937.05f;
	
	
	private int numero;
	
	private Date fechaContrato;
	
	private float salario;

	
	public Employee() {
		super();
		this.numero = 0;
		this.fechaContrato = new Date();
		this.salario = SALARIO_MINIMO;	
	}
		

	public Employee(String nombre, int edad, char sexo, float salario) {
				
		super(nombre, edad, sexo);
		
		this.numero = 0;
		this.fechaContrato = new Date();
		this.salario = salario;
	}



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return super.toString() + " Employee [numero=" + numero + ", fechaContrato=" + fechaContrato + ", salario=" + salario + "]";
	}
	
	
	
}
