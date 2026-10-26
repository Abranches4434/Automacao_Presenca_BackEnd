package com.automacao.backend.application.usecases.usuario;

import com.automacao.backend.application.dto.usuario.UsuarioRequest;
import com.automacao.backend.application.dto.usuario.UsuarioShortResponse;
import com.automacao.backend.application.infrastructure.exception.DataAlreadyRegistered;
import com.automacao.backend.domain.Usuario;
import com.automacao.backend.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Service
public class AddUsuarioUseCase {
    private final UsuarioRepository repository;
    private final ObjectMapper mapper;
    private final PasswordEncoder encoder;

    @Transactional
    public UsuarioShortResponse execute(UsuarioRequest request) {
        validate(request);

        Usuario usuario = mapper.convertValue(request, Usuario.class);
        usuario.setSenha(encoder.encode(request.senha()));

        repository.save(usuario);

        return mapper.convertValue(usuario, UsuarioShortResponse.class);
    }

    private void validate(UsuarioRequest request) {
        if (repository.existsByEmail(request.email()))
            throw new DataAlreadyRegistered("Não é possível registrar um usuário com esse email.");

        if (repository.existsByCpf(request.cpf()))
            throw new DataAlreadyRegistered("Não é possível registrar um usuário com esse cpf.");
    }
}
