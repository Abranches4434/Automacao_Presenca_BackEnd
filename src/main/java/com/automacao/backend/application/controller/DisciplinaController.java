package com.automacao.backend.application.controller;

import com.automacao.backend.application.dto.disciplina.DisciplinaRequest;
import com.automacao.backend.application.dto.disciplina.DisciplinaShortResponse;
import com.automacao.backend.application.usecases.disciplina.*;
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
@RequestMapping("/disciplinas")
@Tag(name = "Disciplinas", description = "Gerenciamento de disciplinas")
public class DisciplinaController {
    private final GetAllDisciplinasUseCase getAllDisciplinasUseCase;
    private final GetDisciplinaByIdUseCase getDisciplinaByIdUseCase;
    private final AddDisciplinaUseCase addDisciplinaUseCase;
    private final UpdateDisciplinaUseCase updateDisciplinaUseCase;
    private final DisableDisciplinaUseCase disableDisciplinaUseCase;

    @GetMapping
    public ResponseEntity<Page<DisciplinaShortResponse>> obterTodos(@ParameterObject Pageable pageable) {
        Page<DisciplinaShortResponse> response = getAllDisciplinasUseCase.execute(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaShortResponse> obterPorId(@PathVariable UUID id) {
        DisciplinaShortResponse response = getDisciplinaByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DisciplinaShortResponse> salvar(@RequestBody @Valid DisciplinaRequest request) {
        DisciplinaShortResponse response = addDisciplinaUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody @Valid DisciplinaRequest request) {
        updateDisciplinaUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> desabilitar(@PathVariable UUID id) {
        disableDisciplinaUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
