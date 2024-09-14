package com.ebac.modulo36.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;


@Entity
@Table(name="telefonos")
public class Telefono {

	@Override
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTelefono;

	@Column(name= "IdUsuario")
	private int idUsuario;

	@Column(name= "numero")
	private String numero;

	@Column(name = "tipo")
	private String tipo;

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "telefonos {" +
				"idTelefono=" + idTelefono  +
				", idUsuario=" + idUsuario +
				", numero='" + numero + '\'' +
				", tipo='" + tipo + '\'' +
				'}';
	}
}
