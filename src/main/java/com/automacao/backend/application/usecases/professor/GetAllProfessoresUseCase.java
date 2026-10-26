package com.automacao.backend.application.usecases.professor;

import com.automacao.backend.application.dto.professor.ProfessorShortResponse;
import com.automacao.backend.domain.Professor;
import com.automacao.backend.domain.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetAllProfessoresUseCase {
    private final ProfessorRepository repository;

    public Page<ProfessorShortResponse> execute(Pageable pageable) {
        Page<Professor> professores = repository.findAll(pageable);

        return professores.map(ProfessorShortResponse::fromEntity);
    }
}
