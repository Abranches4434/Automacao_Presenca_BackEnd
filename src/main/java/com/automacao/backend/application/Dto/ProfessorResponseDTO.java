package com.automacao.backend.application.Dto;

import com.automacao.backend.domain.Entities.ProfessorEntity;

public class ProfessorResponseDTO extends UsuarioResponseDTO {

	private final String registro;
	private final String departamento;

	public ProfessorResponseDTO(ProfessorEntity entity) {
		super(entity);
		this.registro = entity.getRegistro();
		this.departamento = entity.getDepartamento();
	}

	public String getRegistro() {
		return registro;
	}

	public String getDepartamento() {
		return departamento;
	}
}
