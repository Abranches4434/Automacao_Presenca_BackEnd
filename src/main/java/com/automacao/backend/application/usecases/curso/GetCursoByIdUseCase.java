package com.automacao.backend.application.usecases.curso;

import com.automacao.backend.application.dto.curso.CursoShortResponse;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Curso;
import com.automacao.backend.domain.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

@AllArgsConstructor
@Service
public class GetCursoByIdUseCase {
    private final CursoRepository repository;
    private final ObjectMapper mapper;

    public CursoShortResponse execute(UUID id) {
        Curso curso = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Curso não encontrado.")
        );

        return mapper.convertValue(curso, CursoShortResponse.class);
    }
}
