package com.automacao.backend.application.controller;

import com.automacao.backend.application.dto.professor.ProfessorRequest;
import com.automacao.backend.application.dto.professor.ProfessorShortResponse;
import com.automacao.backend.application.usecases.professor.*;
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
@RequestMapping("/professores")
@Tag(name = "Professores", description = "Gerenciamento de professores")
public class ProfessorController {
    private final GetAllProfessoresUseCase getAllProfessoresUseCase;
    private final GetProfessorByIdUseCase getProfessorByIdUseCase;
    private final AddProfessorUseCase addProfessorUseCase;
    private final UpdateProfessorUseCase updateProfessorUseCase;
    private final DisableProfessorUseCase disableProfessorUseCase;

    @GetMapping
    public ResponseEntity<Page<ProfessorShortResponse>> obterTodos(@ParameterObject Pageable pageable) {
        Page<ProfessorShortResponse> response = getAllProfessoresUseCase.execute(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorShortResponse> obterPorId(@PathVariable UUID id) {
        ProfessorShortResponse response = getProfessorByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProfessorShortResponse> salvar(@RequestBody @Valid ProfessorRequest request) {
        ProfessorShortResponse response = addProfessorUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody @Valid ProfessorRequest request) {
        updateProfessorUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> desabilitar(@PathVariable UUID id) {
        disableProfessorUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
