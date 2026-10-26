package com.automacao.backend.application.usecases.estudante;

import com.automacao.backend.application.dto.estudante.EstudanteShortResponse;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Estudante;
import com.automacao.backend.domain.repository.EstudanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class GetEstudanteByIdUseCase {
    private final EstudanteRepository repository;

    public EstudanteShortResponse execute(UUID id) {
        Estudante estudante = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Estudante não encontrado.")
        );

        return EstudanteShortResponse.fromEntity(estudante);
    }
}
