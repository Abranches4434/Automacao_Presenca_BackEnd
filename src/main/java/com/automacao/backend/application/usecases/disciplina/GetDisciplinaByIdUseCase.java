package com.automacao.backend.application.usecases.disciplina;

import com.automacao.backend.application.dto.disciplina.DisciplinaShortResponse;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Disciplina;
import com.automacao.backend.domain.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

@AllArgsConstructor
@Service
public class GetDisciplinaByIdUseCase {
    private final DisciplinaRepository repository;
    private final ObjectMapper mapper;

    public DisciplinaShortResponse execute(UUID id) {
        Disciplina disciplina = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Disciplina não encontrada.")
        );

        return mapper.convertValue(disciplina, DisciplinaShortResponse.class);
    }
}
