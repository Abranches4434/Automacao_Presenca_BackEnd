package com.automacao.backend.application.dto.estudante;

import com.automacao.backend.application.dto.curso.CursoShortResponse;
import com.automacao.backend.domain.Estudante;

import java.util.UUID;

public record EstudanteShortResponse(
	UUID id,
	UUID usuarioId,
	CursoShortResponse curso,
	boolean status
) {
	public static EstudanteShortResponse fromEntity(Estudante estudante) {
		return new EstudanteShortResponse(
			estudante.getId(),
			estudante.getUsuario().getId(),
			new CursoShortResponse(
				estudante.getCurso().getId(),
				estudante.getCurso().getNome(),
				estudante.getCurso().getDescricao(),
				estudante.getCurso().getStatus()
			),
			estudante.getStatus()
		);
	}
}
