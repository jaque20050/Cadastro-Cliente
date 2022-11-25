package br.com.criandoapi.projeto.repository.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;

@Service
public class UsuarioService {

	private IUsuario repository;

	private PasswordEncoder passwordEncoder;

	public UsuarioService(IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public List<Usuario> listarUsuario() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}

	public Usuario criarUsuario(Usuario usuario) {
		String enconder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(enconder);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}

	public Usuario atualizarUsuario(Usuario usuario) {
		String enconder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(enconder);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}

	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}

	public Boolean validarSenha(Usuario usuario) {
		String senha = repository.getReferenceById(usuario.getId()).getSenha();
		Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
		return valid;
	}

}
