package com.ebac.modulo39.controller;

import com.ebac.modulo39.dto.Usuario;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class UsuarioController {

	@GetMapping("/usuarios")
	public List<Usuario> obtenerUsuarios() {
		//Logica para obtener el usuario por su ID
		//Devuelve un objeto User que se converitrá uatomáticamente en JSON/XML. en la respuesta.
		return List.of(new Usuario());
	}

		@GetMapping("/usuarios/{id}")
		public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
			//Logica para obtener el usuario por su ID
			//Devuelve un objeto User que se converitrá atomáticamente en JSON/XML. en la respuesta.
			System.out.println("Id recibido: " + id);
			return (Usuario) List.of(new Usuario());
	}

	@GetMapping("/usuarios")
	public ResponseEntity<Usuario> creausuario(@RequestBody Usuario usuario) {
		//Logica para obtener el usuario por su ID
		//Retorna ResponseEntity cone el objeto User en el cuerpo y un código de estado 201 (CREATED) en la respuesta.
		System.out.println("Usuario recibido: " + usuario);
		return ResponseEntity.ok(usuario);
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
		//Logica para obtener el usuario por su ID
		//Retorna ResponseEntity cone el objeto User actualizado en el cuerpo y un código de estado 200 (ok) en la respuesta.
		System.out.println("Id recibido: " + id);
		System.out.println("Usuario recibido: " + usuarioActualizado);
		return ResponseEntity.ok(usuarioActualizado);
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Long id) {
		//Logica para obtener el usuario por su ID
		//Retorna ResponseEntity cone el código de estado 204 (NO_CONTENT) sin curespuesta.
		System.out.println("Id recibido: " + id);
		//Si el usuario se eliminó exitosamente, respondemmos con un código de estado 204 (NO_CONTENT) sin cu.
		return ResponseEntity.noContent().build();
	}


}
