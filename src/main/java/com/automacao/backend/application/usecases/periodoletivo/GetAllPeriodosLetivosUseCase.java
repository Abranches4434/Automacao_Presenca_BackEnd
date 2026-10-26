package com.automacao.backend.application.usecases.periodoletivo;

import com.automacao.backend.application.dto.periodoletivo.PeriodoLetivoShortResponse;
import com.automacao.backend.domain.PeriodoLetivo;
import com.automacao.backend.domain.repository.PeriodoLetivoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Service
public class GetAllPeriodosLetivosUseCase {
    private final PeriodoLetivoRepository repository;
    private final ObjectMapper mapper;

    public Page<PeriodoLetivoShortResponse> execute(Pageable pageable) {
        Page<PeriodoLetivo> periodos = repository.findAll(pageable);

        return periodos.map(periodo ->
                mapper.convertValue(periodo, PeriodoLetivoShortResponse.class)
        );
    }
}
