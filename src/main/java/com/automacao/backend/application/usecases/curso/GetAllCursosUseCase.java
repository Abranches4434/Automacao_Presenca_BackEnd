package com.automacao.backend.application.usecases.curso;

import com.automacao.backend.application.dto.curso.CursoShortResponse;
import com.automacao.backend.domain.Curso;
import com.automacao.backend.domain.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Service
public class GetAllCursosUseCase {
    private final CursoRepository repository;
    private final ObjectMapper mapper;

    public Page<CursoShortResponse> execute(Pageable pageable) {
        Page<Curso> cursos = repository.findAll(pageable);

        return cursos.map(curso ->
            mapper.convertValue(curso, CursoShortResponse.class)
        );
    }
}
