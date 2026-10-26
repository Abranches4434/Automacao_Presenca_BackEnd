package com.automacao.backend.application.usecases.estudante;

import com.automacao.backend.application.dto.estudante.EstudanteShortResponse;
import com.automacao.backend.domain.Estudante;
import com.automacao.backend.domain.repository.EstudanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetAllEstudantesUseCase {
    private final EstudanteRepository repository;

    public Page<EstudanteShortResponse> execute(Pageable pageable) {
        Page<Estudante> estudantes = repository.findAll(pageable);

        return estudantes.map(EstudanteShortResponse::fromEntity);
    }
}
