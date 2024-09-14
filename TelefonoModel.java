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

public class TelefonoModel {

		private final MongoCollection<Document> collection;

		public TelefonoModel(MongoDatabase database) {
			   TelefonoModel
			collection = database.getCollection("telefonos");
		}

		public void guardar(Document document) {
			// Insertar el nuevo registro en la coleccion
			collection.insertOne(document);
		}

		public void obtener() {
			// Obtener todos los registros (telefonos) de la coleccion
			FindIterable<Document> telefonos = collection.find();

			// Mostrar los resultados
			for (Document telefono : telefonos) {
				Object id = telefono.getObjectId("_id");
				int idUsuario = telefono.getString("idUsuario");
				String numero = telefono.getString("numero");
				String tipo = telefono.getInteger("tipo");
				System.out.println("Id: " + id + ", Idusuario: " + idUsuario + ", numero : " + numero + ", tipo :" + tipo);

				System.out.println(telefono);
			}
		}

		public Optional<Document> obtenerPorId(Document document) {
			// Obtener todos los registros que hagan match cone el doc
			Document telefono = collection.find(document).first();

			if(!Object.isNull(telefono)) {
				//Mostrar los resultados
				ObjectId telefono.getObjectId("_id");
				int idUsuario = idUsuario.getInteger("idUsuario");
				String numero = telefono.getString("numero");
				String tipo = telefono.getString("tipo");
				System.out.println("Id: " + id + ", Idusuario: " + idUsuario + ", numero : " + numero + ", tipo :" + tipo);

				return Optional.of(telefono);
			}

			return	Optional.empty();
		}

		public void actualizar (Document documentoActual, Document documentoNuevo) {
			// Actualizar el libro que cumple con el filtro
			UpdateResult updateResult = collection.updateOne(documentoActual, documentoNuevo);

			if (updateResult.getModifiedCount() > 0) {
				System.out.println("Telefono actualizado con éxito.");
			} else {
				System.out.println("El telefono no fue encontrado.");
			}
		}

		public void eliminar(Document document) {
			// Eliminar el telefono que cumple con el filtro
			DeleteResult deleteResult = collection.deleteOne(document);

			if (deleteResult.getDeletedCount() > 0) {
				System.out.println("Telefono eliminado con éxito.");
			} else {
				System.out.println("El telefono no fue encontrado.");
			}
		}
	}


