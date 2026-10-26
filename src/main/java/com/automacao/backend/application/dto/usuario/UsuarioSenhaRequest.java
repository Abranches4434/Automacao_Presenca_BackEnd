package com.automacao.backend.application.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioSenhaRequest(
    @NotBlank
    @Size(min = 8)
    String novaSenha,

    @NotBlank
    @Size(min = 8)
    String senhaAntiga
) { }
