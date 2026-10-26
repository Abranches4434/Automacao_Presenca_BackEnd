package com.automacao.backend.application.usecases.professor;

import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Professor;
import com.automacao.backend.domain.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DisableProfessorUseCase {
    private final ProfessorRepository repository;

    @Transactional
    public void execute(UUID id) {
        Professor professor = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Professor não encontrado.")
        );

        professor.setStatus(false);

        repository.save(professor);
    }
}
