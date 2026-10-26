package com.automacao.backend.application.usecases.curso;

import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Curso;
import com.automacao.backend.domain.repository.CursoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DisableCursoUseCase {
    private final CursoRepository repository;

    @Transactional
    public void execute(UUID id) {
        Curso curso = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Curso não encontrado.")
        );

        curso.setStatus(false);

        repository.save(curso);
    }
}
