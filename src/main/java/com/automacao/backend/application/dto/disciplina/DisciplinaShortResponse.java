package com.automacao.backend.application.dto.disciplina;

import java.util.UUID;

public record DisciplinaShortResponse(
    UUID id,
    String codigo,
    String nome,
    String ementa,
    Integer cargaHoraria,
    boolean status
) { }
