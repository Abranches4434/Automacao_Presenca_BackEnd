package com.automacao.backend.application.usecases.disciplina;

import com.automacao.backend.application.dto.disciplina.DisciplinaShortResponse;
import com.automacao.backend.domain.Disciplina;
import com.automacao.backend.domain.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Service
public class GetAllDisciplinasUseCase {
    private final DisciplinaRepository repository;
    private final ObjectMapper mapper;

    public Page<DisciplinaShortResponse> execute(Pageable pageable) {
        Page<Disciplina> disciplinas = repository.findAll(pageable);

        return disciplinas.map(disciplina ->
            mapper.convertValue(disciplina, DisciplinaShortResponse.class)
        );
    }
}
