package com.automacao.backend.application.Dto;

import com.automacao.backend.domain.Entities.ProfessorEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProfessorRequestDTO extends UsuarioRequestDTO {

	@NotBlank
	@Size(max = 20)
	private final String registro;

	@NotBlank
	@Size(max = 100)
	private final String departamento;

	@JsonCreator
	public ProfessorRequestDTO(
			@JsonProperty("nome") String nome,
			@JsonProperty("email") String email,
			@JsonProperty("cpf") String cpf,
			@JsonProperty("registro") String registro,
			@JsonProperty("departamento") String departamento) {
		super(nome, email, cpf);
		this.registro = registro;
		this.departamento = departamento;
	}

	public String getRegistro() {
		return registro;
	}

	public String getDepartamento() {
		return departamento;
	}

	@Override
	public ProfessorEntity DtoToEntity() {
		return new ProfessorEntity(getNome(), getEmail(), getCpf(), registro, departamento);
	}
}
