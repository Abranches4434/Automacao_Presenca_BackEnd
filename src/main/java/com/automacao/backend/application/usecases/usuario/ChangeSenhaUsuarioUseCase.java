package com.automacao.backend.application.usecases.usuario;

import com.automacao.backend.application.dto.usuario.UsuarioSenhaRequest;
import com.automacao.backend.application.infrastructure.exception.InvalidDataException;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Usuario;
import com.automacao.backend.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ChangeSenhaUsuarioUseCase {
    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    //TODO: Remover id por parametro e utilizar servlet authentication
    @Transactional
    public void execute(UUID id, UsuarioSenhaRequest request) {
        Usuario usuario = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Usuário não encontrado.")
        );

        validated(usuario.getSenha(), request.senhaAntiga());

        usuario.setSenha(encoder.encode(request.novaSenha()));

        repository.save(usuario);
    }

    private void validated(String senhaHash, String senhaAntiga) {
        if (!encoder.matches(senhaAntiga, senhaHash))
            throw new InvalidDataException("Falha ao conferir antiga senha, a senha não coincide.");
    }
}
