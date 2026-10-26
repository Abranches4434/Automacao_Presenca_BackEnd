package com.automacao.backend.application.dto.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CursoRequest(
    @NotBlank
    @Size(max = 100)
    String nome,

    @NotBlank
    @Size(max = 200)
    String descricao
) { }
