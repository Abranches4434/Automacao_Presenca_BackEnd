package com.automacao.backend.application.dto.usuario;

import java.util.UUID;

public record UsuarioShortResponse(
	UUID id,
	String nome,
	String email
) { }
