package com.automacao.backend.application.usecases.disciplina;

import com.automacao.backend.application.dto.disciplina.DisciplinaRequest;
import com.automacao.backend.application.infrastructure.exception.DataAlreadyRegistered;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Disciplina;
import com.automacao.backend.domain.repository.DisciplinaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UpdateDisciplinaUseCase {
    private final DisciplinaRepository repository;

    @Transactional
    public void execute(UUID id, DisciplinaRequest request) {
        Disciplina disciplina = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Disciplina não encontrada.")
        );

        validate(id, request);

        disciplina.setCodigo(request.codigo());
        disciplina.setNome(request.nome());
        disciplina.setEmenta(request.ementa());
        disciplina.setCargaHoraria(request.cargaHoraria());

        repository.save(disciplina);
    }

    private void validate(UUID id, DisciplinaRequest request) {
        if (repository.existsByCodigoAndIdNot(request.codigo(), id))
            throw new DataAlreadyRegistered("Não é possível registrar uma disciplina com esse código.");
    }
}
