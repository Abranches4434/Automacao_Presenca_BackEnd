package com.automacao.backend.application.usecases.estudante;

import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Estudante;
import com.automacao.backend.domain.repository.EstudanteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DisableEstudanteUseCase {
    private final EstudanteRepository repository;

    @Transactional
    public void execute(UUID id) {
        Estudante estudante = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Estudante não encontrado.")
        );

        estudante.setStatus(false);

        repository.save(estudante);
    }
}
