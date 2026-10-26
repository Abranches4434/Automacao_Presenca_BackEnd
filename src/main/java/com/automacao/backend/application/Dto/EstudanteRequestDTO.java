package com.automacao.backend.application.Dto;

import com.automacao.backend.domain.Entities.EstudanteEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EstudanteRequestDTO extends UsuarioRequestDTO {

	@NotBlank
	@Size(max = 20)
	private final String matricula;

	@NotBlank
	@Size(max = 100)
	private final String curso;

	@JsonCreator
	public EstudanteRequestDTO(
			@JsonProperty("nome") String nome,
			@JsonProperty("email") String email,
			@JsonProperty("cpf") String cpf,
			@JsonProperty("matricula") String matricula,
			@JsonProperty("curso") String curso) {
		super(nome, email, cpf);
		this.matricula = matricula;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCurso() {
		return curso;
	}

	@Override
	public EstudanteEntity DtoToEntity() {
		return new EstudanteEntity(getNome(), getEmail(), getCpf(), matricula, curso);
	}
}
