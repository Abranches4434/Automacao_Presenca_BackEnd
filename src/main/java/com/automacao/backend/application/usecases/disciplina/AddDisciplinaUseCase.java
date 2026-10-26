package com.automacao.backend.application.usecases.disciplina;

import com.automacao.backend.application.dto.disciplina.DisciplinaRequest;
import com.automacao.backend.application.dto.disciplina.DisciplinaShortResponse;
import com.automacao.backend.application.infrastructure.exception.DataAlreadyRegistered;
import com.automacao.backend.domain.Disciplina;
import com.automacao.backend.domain.repository.DisciplinaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Service
public class AddDisciplinaUseCase {
    private final DisciplinaRepository repository;
    private final ObjectMapper mapper;

    @Transactional
    public DisciplinaShortResponse execute(DisciplinaRequest request) {
        validate(request);

        Disciplina disciplina = mapper.convertValue(request, Disciplina.class);

        repository.save(disciplina);

        return mapper.convertValue(disciplina, DisciplinaShortResponse.class);
    }

    private void validate(DisciplinaRequest request) {
        if (repository.existsByCodigo(request.codigo()))
            throw new DataAlreadyRegistered("Não é possível registrar uma disciplina com esse código.");
    }
}
