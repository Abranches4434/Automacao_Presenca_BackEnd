package com.automacao.backend.application.dto.periodoletivo;

import java.time.LocalDate;
import java.util.UUID;

public record PeriodoLetivoShortResponse(
    UUID id,
    String nome,
    LocalDate dataInicio,
    LocalDate dataFim,
    boolean status
) { }
