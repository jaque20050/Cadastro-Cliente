package br.com.criandoapi.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "O nome é obrigatorio")
	@Size(min = 3, message = "O nome deve ter no minimo 3 caracteres")
	@Column(name = "nome", length = 200, nullable = false)
	private String nome;

	@Email(message = "Insira um email válido!")
	@NotBlank(message = "O email é obrigatório")
	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@NotBlank(message = "A senha é obrigatorio")
	@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
	private String senha;

	@NotBlank(message = "O telefone é obrigatorio")
	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;

}
