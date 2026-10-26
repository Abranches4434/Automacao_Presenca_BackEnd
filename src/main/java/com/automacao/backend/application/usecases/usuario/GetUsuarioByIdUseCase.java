package com.automacao.backend.application.usecases.usuario;

import com.automacao.backend.application.dto.usuario.UsuarioShortResponse;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Usuario;
import com.automacao.backend.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

@AllArgsConstructor
@Service
public class GetUsuarioByIdUseCase {
    private final UsuarioRepository repository;
    private final ObjectMapper mapper;

    public UsuarioShortResponse execute(final UUID id) {
        Usuario usuario = repository.findById(id).orElseThrow(
            () -> new NotFoundException("O usuario não foi encontrado.")
        );

        return mapper.convertValue(usuario, UsuarioShortResponse.class);
    }
}
