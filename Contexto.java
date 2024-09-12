package com.ebac.modulo34.recursos;

import com.ebac.modulo33.MysqlConnection;
import com.ebac.modulo34.dto.Direccion;
import com.ebac.modulo34.dto.Telefono;
import com.ebac.modulo34.dto.Usuario;
import com.ebac.modulo34.model.DireccionModel;
import com.ebac.modulo34.model.TelefonoModel;
import com.ebac.modulo34.model.UsuarioModel;

import java.sql.Connection;
import java.sql.SQLException;

public class Contexto {

	static Connection connection;

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/modulo33";
		String user = "root";
		String password = "root";

		MysqlConnection mysqlConnection = new MysqlConnection();
		connection = mysqlConnection.getConnection(url, user, password);

		operacionConUsuarios();
		operacionConTelefonos();
		operacionConDirecciones();

		connection.close();
	}

	public static void operacionConUsuarios() throws SQLException {
		System.out.println("------------OPERACION CON USUARIOS -------------------------------");
		Usuario usuarioMaria = creaUsuario("Maria", 25);
		Usuario usuarioJulian = creaUsuario("Julian", 23);

		UsuarioModel usuarioModel = new UsuarioModel(connection);
		Usuario maria = usuarioModel.guardar(usuarioMaria);
		Usuario julian = usuarioModel.guardar(usuarioJulian);

		System.out.println(maria);
		System.out.println(julian);
		System.out.println("----------------------------------------------------------------------");

		Usuario usuario1EnDB = usuarioModel.obtenerPorId(1);
		System.out.println(usuario1EnDB);

		Usuario usuario2EnDB = usuarioModel.obtenerPorId(2);
		System.out.println(usuario2EnDB);
		System.out.println("----------------------------------------------------------------------");


		Usuario usuarioInexistente = usuarioModel.obtenerPorId(3);
		System.out.println(usuarioInexistente);
		System.out.println("----------------------------------------------------------------------");

		usuarioModel.eliminarPorId(2);
		Usuario usuario2Eliminado = usuarioModel.obtenerPorId(2);
		System.out.println(usuario2Eliminado);
		System.out.println("----------------------------------------------------------------------");
	}

	public static void operacionConTelefonos() throws SQLException {
		System.out.println("-------------------OPERACION CON TELEFONOS --------------------");
		Telefono telefono1 = creaTelefono(1, "55-1111-2222", "casa");
		Telefono telefono2 = creaTelefono(2, "55-4523-2533", "celular");
		Telefono telefono3 = creaTelefono(4, "55-7893-22302", "oficina");

		//Registro de telefonos
		TelefonoModel telefonoModel = new TelefonoModel(connection);
		telefonoModel.guardar(telefono1);
		telefonoModel.guardar(telefono2);
		telefonoModel.guardar(telefono3);

		//Consulta de telefonos
		Telefono telefonoEnBD1 = telefonoModel.obtenerPorId(1);
		Telefono telefonoEnBD2 = telefonoModel.obtenerPorId(2);
		Telefono telefonoEnBD3 = telefonoModel.obtenerPorId(3);

		System.out.println(telefonoEnBD1);
		System.out.println(telefonoEnBD2);
		System.out.println(telefonoEnBD3);
	}

	public static void operacionConDirecciones() throws SQLException {
		System.out.println("------------OPERACION CON DIRECCIONES -------------------------------");




	}

	private static Usuario creaUsuario(String nombre, int edad) {
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setEdad(edad);
		return usuario;
	}

	public static Telefono creaTelefono(int IdUsuario, String numero, String tipo) {
		Telefono telefono = new Telefono();
		telefono.setIdUsuario(IdUsuario);
		telefono.setNumero(numero);
		telefono.setTipo(tipo);
		return telefono;
	}

	public static Direccion creaDireccion(int IdUsuario, String calle, int numero, String estado) {
		Direccion direccion = new Direccion();
		direccion.setIdUsuario(IdUsuario);
		direccion.setCalle(calle);
		direccion.setNumero(numero);
		direccion.setEstado(estado);
		return direccion;
	}
}
