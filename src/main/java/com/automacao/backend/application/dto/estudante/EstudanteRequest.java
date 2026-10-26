package com.automacao.backend.application.dto.estudante;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EstudanteRequest(
	@NotNull
	UUID usuarioId,

	@NotNull
	UUID cursoId
) { }
