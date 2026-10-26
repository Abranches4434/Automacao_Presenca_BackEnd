package com.automacao.backend.application.Dto;

import com.automacao.backend.domain.Entities.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public abstract class UsuarioRequestDTO {

	@NotBlank
	@Size(max = 100)
	private final String nome;

	@NotBlank
	@Email
	@Size(max = 150)
	private final String email;

	@NotBlank
	@Size(max = 11)
	@CPF
	private final String cpf;

	protected UsuarioRequestDTO(@JsonProperty("nome") String nome,
							@JsonProperty("email") String email,
							@JsonProperty("cpf") String cpf) {
				this.nome = nome;
				this.email = email;
				this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public abstract UsuarioEntity DtoToEntity();
}
