package com.automacao.backend.application.usecases.periodoletivo;

import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.PeriodoLetivo;
import com.automacao.backend.domain.repository.PeriodoLetivoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DisablePeriodoLetivoUseCase {
    private final PeriodoLetivoRepository repository;

    @Transactional
    public void execute(UUID id) {
        PeriodoLetivo periodo = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Período letivo não encontrado.")
        );

        periodo.setStatus(false);

        repository.save(periodo);
    }
}
