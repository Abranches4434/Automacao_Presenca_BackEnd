package com.automacao.backend.application.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public record UsuarioRequest(
	@NotBlank
	@Size(max = 100)
	String nome,

	@NotBlank
	@Email
	@Size(max = 150)
	String email,

	@NotBlank
	@Size(min = 8)
	String senha,

	@NotBlank
	@Size(max = 11)
	@CPF
	String cpf
) { }
