package com.ipartek.formacion;

import java.util.Comparator;

public class ComparadorCerdosDiamantes implements Comparator<Ordenable> {


	@Override
	public int compare(Ordenable o1, Ordenable o2) {
		return o1.getValor() - o2.getValor();
	}

}
