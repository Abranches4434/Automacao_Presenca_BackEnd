package com.automacao.backend.application.usecases.periodoletivo;

import com.automacao.backend.application.dto.periodoletivo.PeriodoLetivoRequest;
import com.automacao.backend.application.dto.periodoletivo.PeriodoLetivoShortResponse;
import com.automacao.backend.application.infrastructure.exception.DataAlreadyRegistered;
import com.automacao.backend.application.infrastructure.exception.InvalidDataException;
import com.automacao.backend.domain.PeriodoLetivo;
import com.automacao.backend.domain.repository.PeriodoLetivoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@AllArgsConstructor
@Service
public class AddPeriodoLetivoUseCase {
    private final PeriodoLetivoRepository repository;
    private final ObjectMapper mapper;

    @Transactional
    public PeriodoLetivoShortResponse execute(PeriodoLetivoRequest request) {
        validate(request);

        PeriodoLetivo periodo = mapper.convertValue(request, PeriodoLetivo.class);

        repository.save(periodo);

        return mapper.convertValue(periodo, PeriodoLetivoShortResponse.class);
    }

    private void validate(PeriodoLetivoRequest request) {
        if (!request.dataFim().isAfter(request.dataInicio()))
            throw new InvalidDataException("A data de fim deve ser posterior à data de início.");

        if (repository.existsByNome(request.nome()))
            throw new DataAlreadyRegistered("Não é possível registrar um período letivo com esse nome.");
    }
}
