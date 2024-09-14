package com.ebac.modulo36.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuario {
	@Override
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name= "nombre")
	private String nombre;

	@Column(name = "edad")
	private int edad;

	public int getIdUsuario() { return idUsuario; }

	public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

	public String getNombre() { return nombre; }

	public void  setNombre(String nombre) { this.nombre = nombre; }

	public int getEdad() { return edad; }

	@Override
	public String toString() {
		return "Usuario{" +
				"idUsuario=" + idUsuario +
				", nombre=" + nombre + '\'' +
				", edad=" + edad +
				'}';
	}
}
