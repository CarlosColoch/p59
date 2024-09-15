package com.ebac.modulo38.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FiguraService {

/*
	@Autowired
	@Qualifier("cuadrado")
	Figura figura1;  //Cuadrado

	@Autowired
	@Qualifier("triangulo")
	Figura figura2; // Triangulo

	public void imprimirNombre1() {
		figura1.nombre();
	}

	public void imprimirNombre2() {
		figura2.nombre();
	}
*/
	@Autowired
	Figura cuadrado;

	@Autowired
	Figura triangulo;

	public void imprimirNombre1() {
		cuadrado.nombre();
	}

	public void imprimirNombre2() {
		triangulo.nombre();
	}
}