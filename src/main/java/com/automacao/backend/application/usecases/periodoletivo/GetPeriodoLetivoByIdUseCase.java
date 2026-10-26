package com.automacao.backend.application.usecases.periodoletivo;

import com.automacao.backend.application.dto.periodoletivo.PeriodoLetivoShortResponse;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.PeriodoLetivo;
import com.automacao.backend.domain.repository.PeriodoLetivoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

@AllArgsConstructor
@Service
public class GetPeriodoLetivoByIdUseCase {
    private final PeriodoLetivoRepository repository;
    private final ObjectMapper mapper;

    public PeriodoLetivoShortResponse execute(UUID id) {
        PeriodoLetivo periodo = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Período letivo não encontrado.")
        );

        return mapper.convertValue(periodo, PeriodoLetivoShortResponse.class);
    }
}
