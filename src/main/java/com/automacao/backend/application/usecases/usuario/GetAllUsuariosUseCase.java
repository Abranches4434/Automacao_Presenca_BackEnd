package com.automacao.backend.application.usecases.usuario;

import com.automacao.backend.application.dto.usuario.UsuarioShortResponse;
import com.automacao.backend.domain.Usuario;
import com.automacao.backend.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Service
public class GetAllUsuariosUseCase {
    private final UsuarioRepository repository;
    private final ObjectMapper mapper;

    public Page<UsuarioShortResponse> execute(Pageable pageable) {
        Page<Usuario> usuarios = repository.findAll(pageable);

        return usuarios.map(usuario ->
            mapper.convertValue(usuario, UsuarioShortResponse.class)
        );
    }
}
