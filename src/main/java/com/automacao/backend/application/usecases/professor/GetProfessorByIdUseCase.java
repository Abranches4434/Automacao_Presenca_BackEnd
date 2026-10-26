package com.automacao.backend.application.usecases.professor;

import com.automacao.backend.application.dto.professor.ProfessorShortResponse;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Professor;
import com.automacao.backend.domain.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class GetProfessorByIdUseCase {
    private final ProfessorRepository repository;

    public ProfessorShortResponse execute(UUID id) {
        Professor professor = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Professor não encontrado.")
        );

        return ProfessorShortResponse.fromEntity(professor);
    }
}
