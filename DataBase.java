package com.ebac.modulo38.servicio;


import org.springframework.beans.factory.annotation.Value;

import java.awt.*;

public class DataBase {
	@Value("${db.qa.url}")
	String dbUrl;

	@Value("root")
	String user;

	@Value("${VARIABLE_AMBIENTE}")
	String varaiableDeAmbiente;


	public  String getById(int id) {
		System.out.println("Url hacia la base de datos: " + dbUrl);
		System.out.println("Usuario por default: " + user);
		System.out.println("Valor de mi: " + varaiableDeAmbiente);
		return "Elemento con id " + id + " encontrado";

	}
}
