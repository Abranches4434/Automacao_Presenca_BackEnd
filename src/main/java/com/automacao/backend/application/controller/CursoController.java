package com.automacao.backend.application.controller;

import com.automacao.backend.application.dto.curso.CursoRequest;
import com.automacao.backend.application.dto.curso.CursoShortResponse;
import com.automacao.backend.application.usecases.curso.*;
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
@RequestMapping("/cursos")
@Tag(name = "Cursos", description = "Gerenciamento de cursos")
public class CursoController {
    private final GetAllCursosUseCase getAllCursosUseCase;
    private final GetCursoByIdUseCase getCursoByIdUseCase;
    private final AddCursoUseCase addCursoUseCase;
    private final UpdateCursoUseCase updateCursoUseCase;
    private final DisableCursoUseCase disableCursoUseCase;

    @GetMapping
    public ResponseEntity<Page<CursoShortResponse>> obterTodos(@ParameterObject Pageable pageable) {
        Page<CursoShortResponse> response = getAllCursosUseCase.execute(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoShortResponse> obterPorId(@PathVariable UUID id) {
        CursoShortResponse response = getCursoByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CursoShortResponse> salvar(@RequestBody @Valid CursoRequest request) {
        CursoShortResponse response = addCursoUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody @Valid CursoRequest request) {
        updateCursoUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> desabilitar(@PathVariable UUID id) {
        disableCursoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
