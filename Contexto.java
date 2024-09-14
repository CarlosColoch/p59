package com.ebac.modulo36.recursos;

import com.ebac.modulo36.model.TelefonoModel;
import com.ebac.modulo36.model.UsuarioModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.lang.annotation.Documented;
import java.util.Optional;

public class Contexto {
	public static void main(String[] args) {
		String connectionString = "mongodb://root:toor@localhost:27017";
		MongoClient mongoClient = MongoClinets.create(connectionString);
		MongoDatabase database = mongoClient.getDatabase("modulo33");

		UsuarioModel usuarioModel = new UsuarioModel(database);

		System.out.println("***********************  Usuarios  *******************");
		// Crear un usuario
		Document document = new Document("nombre, "Carlos")
				.append("edad", 31);
		.append("profesion", "Programador Java");
		usuarioModel.guardar(document);

		// Listar usuarios
		usuarioModel.obtener();

		// Listar usuario por id
		Object objectId = new ObjectId("54b9d18405148c2056cf6f2b");
		Document documentABuscar = new Document("_id", objectId);
		Optional<Document> usuarioEncontrado = usuarioModel.obtenerPorId(documentABuscar);

		//Actualizar usuario
		usuarioEncontrado.ifPresent(telefonoActual -> {
			Document document  = new Document("nombre", "CarlosActualizado").append("edad", 61);
			Document usuarioActualizado = new Document("$set", document);

			usuarioModel.actualizar(usuarioActual, usuarioActualizado);
		});
		usuarioModel.obtener();

		// Eliminar usuario
		usuarioModel.obtener();
		usuarioEncontrado.ifPresent(usuarioModel::eliminar);
		usuarioModel.obtener();

		System.out.println("***********************  Telefonos  *******************");
		UsuarioModel usuarioModel = new UsuarioModel(database);
		TelefonoModel telefonoModel = new TelefonoModel(database);

		// Crear un registro de telefono
		Document document = new Document("idTelefono, 1)
				.append("numero", "55-4355-2364")
				.append("tipo", "celular");
				telefonoModel.guardar(document);

		// Listar telefonos
		usuarioModel.obtener();

		// Listar telefonos por id
		Object objectId = new ObjectId("54b9d18405148c2056cf6f2b");
		Document documentABuscar = new Document("_id", objectId);
		Optional<Document> telefonoEncontrado = telefonoModel.obtenerPorId(documentABuscar);

		//Actualizar telefonos
		telefonoEncontrado.ifPresent(telefonoActual -> {
			Document document  = new Document("idUsuario", 2).append("numero", "55-2412-58308").append("tipo", "celular");
			Document telefonoActualizado = new Document("$set", document);

			telefonoModel.actualizar(telefonoActual, telefonoActualizado);
		});
		telefonoModel.obtener();

		// Eliminar telefono
		telefonoModel.obtener();
		 //telefonoEncontrado.ifPresent(telefono -> telefonoModel.eliminar(telefonoEncontrado));
		telefonoEncontrado.ifPresent(telefonoModel::eliminar);
		telefonoModel.obtener();

	}
}








