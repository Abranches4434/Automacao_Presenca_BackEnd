package com.automacao.backend.application.controller;

import com.automacao.backend.application.dto.periodoletivo.PeriodoLetivoRequest;
import com.automacao.backend.application.dto.periodoletivo.PeriodoLetivoShortResponse;
import com.automacao.backend.application.usecases.periodoletivo.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/periodos-letivos")
@Tag(name = "Períodos Letivos", description = "Gerenciamento de períodos letivos")
public class PeriodoLetivoController {
    private final GetAllPeriodosLetivosUseCase getAllPeriodosLetivosUseCase;
    private final GetPeriodoLetivoByIdUseCase getPeriodoLetivoByIdUseCase;
    private final AddPeriodoLetivoUseCase addPeriodoLetivoUseCase;
    private final UpdatePeriodoLetivoUseCase updatePeriodoLetivoUseCase;
    private final DisablePeriodoLetivoUseCase disablePeriodoLetivoUseCase;

    @GetMapping
    public ResponseEntity<Page<PeriodoLetivoShortResponse>> obterTodos(@ParameterObject Pageable pageable) {
        Page<PeriodoLetivoShortResponse> response = getAllPeriodosLetivosUseCase.execute(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoLetivoShortResponse> obterPorId(@PathVariable UUID id) {
        PeriodoLetivoShortResponse response = getPeriodoLetivoByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PeriodoLetivoShortResponse> salvar(@RequestBody @Valid PeriodoLetivoRequest request) {
        PeriodoLetivoShortResponse response = addPeriodoLetivoUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody @Valid PeriodoLetivoRequest request) {
        updatePeriodoLetivoUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> desabilitar(@PathVariable UUID id) {
        disablePeriodoLetivoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
