package com.automacao.backend.application.Dto;

import java.util.UUID;

import com.automacao.backend.domain.Entities.UsuarioEntity;

public class UsuarioResponseDTO {

	private final UUID id;
	private final String nome;
	private final String email;
	private final String cpf;

	public UsuarioResponseDTO(UsuarioEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
	}

	public UUID getId() {
		return id;
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
}
