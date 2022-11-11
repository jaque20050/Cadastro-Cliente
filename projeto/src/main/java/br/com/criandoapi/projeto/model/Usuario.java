package br.com.criandoapi.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome_completo", length = 200, nullable = true)
	private String nome_completo;

	@Column(name = "email", length = 50, nullable = true)
	private String email;

	@Column(name = "senha", columnDefinition = "TEXT", nullable = true)
	private String senha;

	@Column(name = "telefone", length = 15, nullable = true)
	private String telefone;
}