package com.automacao.backend.application.usecases.curso;

import com.automacao.backend.application.dto.curso.CursoRequest;
import com.automacao.backend.application.dto.curso.CursoShortResponse;
import com.automacao.backend.domain.Curso;
import com.automacao.backend.domain.repository.CursoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Service
public class AddCursoUseCase {
    private final CursoRepository repository;
    private final ObjectMapper mapper;

    @Transactional
    public CursoShortResponse execute(CursoRequest request) {
        Curso curso = mapper.convertValue(request, Curso.class);

        repository.save(curso);

        return mapper.convertValue(curso, CursoShortResponse.class);
    }
}
