package com.ipartek.formacion;

import java.util.ArrayList;

public class Aula {

	public static void main(String[] args) {

		// declarar array con nombre alumnos
		ArrayList<Person> alumnos = new ArrayList<Person>();
		alumnos.add(new Person("Ander"));
		alumnos.add(new Person("Mounir"));
		alumnos.add(new Person("Andoni"));
		alumnos.add(new Person("Asier"));
		alumnos.add(new Person("Jon C"));
		alumnos.add(new Person("Arkaitz"));
		alumnos.add(new Person("Manuel"));
		alumnos.add(new Person("Eder I"));
		alumnos.add(new Person("Eder S"));
		alumnos.add(new Person("Gaizka"));
		alumnos.add(new Person("Borja"));
		alumnos.add(new Person("Verónica"));
		alumnos.add(new Person("Jon A"));
		alumnos.add(new Person("Jose Luis"));

		/*
		 * String[] alumnos = { "Ander", "Mounir", "Andoni", "Asier", "Jon C",
		 * "Arkaitz", "Aritz", "Manuel", "Iker", "Eder I", "Eder S", "Gaizka", "Borja",
		 * "Verónica", "Jon A", "José Luis"};
		 */
		// generar numero aleatorio 0 - alumnos.length
		int numero = (int) (Math.random() * alumnos.size());

		System.out.println("El Volunatior es " + alumnos.get(numero).getNombre());

		for (int i = 0; i < alumnos.size(); i++) {

			if (numero == i) {

				System.out.println("*** " + alumnos.get(i)); // toString()

			} else {

				System.out.println(i + " " + alumnos.get(i).getNombre());

			}

		} // end for

	}

}
