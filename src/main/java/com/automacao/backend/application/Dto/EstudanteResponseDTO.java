package com.automacao.backend.application.Dto;

import com.automacao.backend.domain.Entities.EstudanteEntity;

public class EstudanteResponseDTO extends UsuarioResponseDTO {

	private final String matricula;
	private final String curso;

	public EstudanteResponseDTO(EstudanteEntity entity) {
		super(entity);
		this.matricula = entity.getMatricula();
		this.curso = entity.getCurso();
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCurso() {
		return curso;
	}
}
