package com.automacao.backend.application.usecases.curso;

import com.automacao.backend.application.dto.curso.CursoRequest;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Curso;
import com.automacao.backend.domain.repository.CursoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UpdateCursoUseCase {
    private final CursoRepository repository;

    @Transactional
    public void execute(UUID id, CursoRequest request) {
        Curso curso = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Curso não encontrado.")
        );

        curso.setNome(request.nome());
        curso.setDescricao(request.descricao());

        repository.save(curso);
    }
}
