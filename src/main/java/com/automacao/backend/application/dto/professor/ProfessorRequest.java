package com.automacao.backend.application.dto.professor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ProfessorRequest(
	@NotNull
	UUID userId,

	@NotBlank
	@Size(max = 20)
	String registro,

	@NotBlank
	@Size(max = 100)
	String departamento
) { }
