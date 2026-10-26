package com.automacao.backend.application.usecases.usuario;

import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Usuario;
import com.automacao.backend.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DisableUsuarioUseCase {
    private final UsuarioRepository repository;

    //TODO: Remover id por parametro e utilizar servlet authentication
    @Transactional
    public void execute(UUID id) {
        Usuario usuario = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Usuário não encontrado.")
        );

        usuario.setStatus(false);

        repository.save(usuario);
    }
}
