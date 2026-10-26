package com.automacao.backend.application.dto.periodoletivo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PeriodoLetivoRequest(
        @NotBlank
        @Size(max = 20)
        String nome,

        @NotNull
        LocalDate dataInicio,

        @NotNull
        LocalDate dataFim
) { }
