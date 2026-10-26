package com.automacao.backend.application.controller;

import com.automacao.backend.application.dto.estudante.EstudanteRequest;
import com.automacao.backend.application.dto.estudante.EstudanteShortResponse;
import com.automacao.backend.application.usecases.estudante.*;
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
@RequestMapping("/estudantes")
@Tag(name = "Estudantes", description = "Gerenciamento de estudantes")
public class EstudanteController {
    private final GetAllEstudantesUseCase getAllEstudantesUseCase;
    private final GetEstudanteByIdUseCase getEstudanteByIdUseCase;
    private final AddEstudanteUseCase addEstudanteUseCase;
    private final UpdateEstudanteUseCase updateEstudanteUseCase;
    private final DisableEstudanteUseCase disableEstudanteUseCase;

    @GetMapping
    public ResponseEntity<Page<EstudanteShortResponse>> obterTodos(@ParameterObject Pageable pageable) {
        Page<EstudanteShortResponse> response = getAllEstudantesUseCase.execute(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteShortResponse> obterPorId(@PathVariable UUID id) {
        EstudanteShortResponse response = getEstudanteByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EstudanteShortResponse> salvar(@RequestBody @Valid EstudanteRequest request) {
        EstudanteShortResponse response = addEstudanteUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody @Valid EstudanteRequest request) {
        updateEstudanteUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> desabilitar(@PathVariable UUID id) {
        disableEstudanteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
