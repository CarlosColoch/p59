package com.ebac.modulo36.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mysql.cj.xdevapi.UpdateResult;
import org.bson.Document;
//Import org bson.types.ObjectId;

import com.mongodb.client.FindIterable;

//import javax.print.Doc;
import javax.swing.text.Document;
import java.awt.*;
import java.util.Objects;
import java.util.Optional;

public class UsuarioModel {

		private final MongoCollection<Document> collection;

		public UsuarioModel(MongoDatabase database) {
			collection = database.getCollection("usuarios");
		}

	 	public void guardar(Document document) {
			// Insertar el nuevo libro en la coleccion
			collection.insertOne(document);
		}

		public void obtener() {
			// Obtener todos los documentos (usuarios) de la coleccion
			FindIterable<Document> usuarios = collection.find();

			// Mostrar los resultados
			for (Document usuario : usuarios) {
				Object id = usuario.getObjectId("_id");
				String nombre = usuario.getString("nombre");
				int edad = usuario.getInteger("edad");
				System.out.println("Id: " + id + ", Nombre: " + nombre + ", edad : " + edad);

				//System.out.println(usuario);
			}
		}

public Optional<Document> obtenerPorId(Document document) {
	// Obtener todos los docuemntos (usuarios) que hagan match cone el doc
	Document usuario = collection.find(document).first();

	if(!Object.isNull(usuario)) {
		//Mostrar los resultados
		ObjectId usuario.getObjectId("_id");
		String nombre = usuario.getString("nombre");
		int edad = usuario.getInteger("edad");
		System.out.println("Id: "+id +", Nombre: " + nombre +", edad : " + edad);

		//System.out.println(usuario);
		return Optional.of(usuario);
	}

	return	Optional.empty();
}

public void actualizar (Document documentoActual, Document documentoNuevo) {
		// Actualizar el libro que cumple con el filtro
	UpdateResult updateResult = collection.updateOne(documentoActual, documentoNuevo);

	if (updateResult.getModifiedCount() > 0) {
		System.out.println("Usuario actualizado con éxito.");
	} else {
		System.out.println("El usuario no fue encontrado.");
	}
}

public void eliminar(Document document) {
		// Eliminar el usuario que cumple con el filtro
		DeleteResult deleteResult = collection.deleteOne(document);

		if (deleteResult.getDeletedCount() > 0) {
			System.out.println("Usuario eliminado con éxito.");
		} else {
			System.out.println("El usuario no fue encontrado.");
		}
	}
}












