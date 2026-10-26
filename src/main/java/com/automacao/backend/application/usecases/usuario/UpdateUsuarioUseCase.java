package com.automacao.backend.application.usecases.usuario;

import com.automacao.backend.application.dto.usuario.UsuarioUpdateRequest;
import com.automacao.backend.application.infrastructure.exception.DataAlreadyRegistered;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Usuario;
import com.automacao.backend.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UpdateUsuarioUseCase {
    private final UsuarioRepository repository;

    //TODO: Remover id por parametro e utilizar servlet authentication
    @Transactional
    public void execute(UUID id, UsuarioUpdateRequest request) {
        validate(request);

        Usuario usuario = repository.findById(id).orElseThrow(
            () -> new NotFoundException("O usuário não foi encontrado.")
        );

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());

        repository.save(usuario);
    }

    private void validate(UsuarioUpdateRequest request) {
        if (repository.existsByEmail(request.email()))
            throw new DataAlreadyRegistered("Não é possível registrar um usuário com esse email.");
    }
}
