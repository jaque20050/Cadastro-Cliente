package br.com.criandoapi.projeto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.repository.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService service;

	public UsuarioController(UsuarioService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios() {
		return ResponseEntity.status(200).body(service.listarUsuario());
	}

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(service.criarUsuario(usuario));
	}

	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(200).body(service.atualizarUsuario(usuario));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
		service.excluirUsuario(id);
		return ResponseEntity.status(204).build();
	}

	@PostMapping("/login")
	public ResponseEntity<Usuario> validarSenha(@Valid @RequestBody Usuario usuario) {
		Boolean valid = service.validarSenha(usuario);
		/*
		 * Validar a senha do usuário, caso insira incorretamento, não será
		 * liberado acesso.
		 */
		if (!valid) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.status(200).build();

	}

	/*
	 * Tratamento erros e exceções, pega e insira em uma lista, e faz a validação de
	 * dados
	 * 
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);

		});

		return errors;
	}
}
