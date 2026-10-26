package com.automacao.backend.application.dto.curso;

import java.util.UUID;

public record CursoShortResponse(
    UUID id,
    String nome,
    String descricao,
    boolean status
) { }
