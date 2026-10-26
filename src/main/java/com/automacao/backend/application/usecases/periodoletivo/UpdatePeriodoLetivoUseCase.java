package com.automacao.backend.application.usecases.periodoletivo;

import com.automacao.backend.application.dto.periodoletivo.PeriodoLetivoRequest;
import com.automacao.backend.application.infrastructure.exception.DataAlreadyRegistered;
import com.automacao.backend.application.infrastructure.exception.InvalidDataException;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.PeriodoLetivo;
import com.automacao.backend.domain.repository.PeriodoLetivoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UpdatePeriodoLetivoUseCase {
    private final PeriodoLetivoRepository repository;

    @Transactional
    public void execute(UUID id, PeriodoLetivoRequest request) {
        PeriodoLetivo periodo = repository.findById(id).orElseThrow(
            () -> new NotFoundException("Período letivo não encontrado.")
        );

        validate(id, request);

        periodo.setNome(request.nome());
        periodo.setDataInicio(request.dataInicio());
        periodo.setDataFim(request.dataFim());

        repository.save(periodo);
    }

    private void validate(UUID id, PeriodoLetivoRequest request) {
        if (!request.dataFim().isAfter(request.dataInicio()))
            throw new InvalidDataException("A data de fim deve ser posterior à data de início.");

        if (repository.existsByNomeAndIdNot(request.nome(), id))
            throw new DataAlreadyRegistered("Não é possível registrar um período letivo com esse nome.");
    }
}
