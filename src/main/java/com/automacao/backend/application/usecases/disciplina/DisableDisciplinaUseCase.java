package com.automacao.backend.application.usecases.disciplina;

import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Disciplina;
import com.automacao.backend.domain.repository.DisciplinaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DisableDisciplinaUseCase {
    private final DisciplinaRepository repository;

    @Transactional
    public void execute(UUID id) {
        Disciplina disciplina = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Disciplina não encontrada.")
        );

        disciplina.setStatus(false);

        repository.save(disciplina);
    }
}
