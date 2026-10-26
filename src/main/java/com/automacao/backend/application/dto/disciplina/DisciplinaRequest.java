package com.automacao.backend.application.dto.disciplina;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record DisciplinaRequest(
        @NotBlank
        @Size(max = 20)
        String codigo,

        @NotBlank
        @Size(max = 100)
        String nome,

        @Size(max = 1000)
        String ementa,

        @NotNull
        @Positive
        Integer cargaHoraria
) { }
