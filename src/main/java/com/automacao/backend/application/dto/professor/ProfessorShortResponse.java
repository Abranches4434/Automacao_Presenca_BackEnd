package com.automacao.backend.application.dto.professor;

import com.automacao.backend.domain.Professor;

import java.util.UUID;

public record ProfessorShortResponse(
	UUID id,
	UUID usuarioId,
	String registro,
	String departamento
) {
	public static ProfessorShortResponse fromEntity(Professor professor) {
		return new ProfessorShortResponse(
			professor.getId(),
			professor.getUsuario().getId(),
			professor.getRegistro(),
			professor.getDepartamento()
		);
	}
}
