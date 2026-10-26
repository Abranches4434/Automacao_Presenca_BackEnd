package com.automacao.backend.application.controller;

import com.automacao.backend.application.dto.usuario.UsuarioRequest;
import com.automacao.backend.application.dto.usuario.UsuarioSenhaRequest;
import com.automacao.backend.application.dto.usuario.UsuarioShortResponse;
import com.automacao.backend.application.dto.usuario.UsuarioUpdateRequest;
import com.automacao.backend.application.usecases.usuario.*;
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
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
public class UsuarioController {
    private final GetAllUsuariosUseCase getAllUsuariosUseCase;
    private final GetUsuarioByIdUseCase getUsuarioByIdUseCase;
    private final AddUsuarioUseCase addUsuarioUseCase;
    private final UpdateUsuarioUseCase updateUsuarioUseCase;
    private final ChangeSenhaUsuarioUseCase changeSenhaUsuarioUseCase;
    private final DisableUsuarioUseCase disableUsuarioUseCase;

    @GetMapping
    public ResponseEntity<Page<UsuarioShortResponse>> obterTodos(@ParameterObject Pageable pageable) {
        Page<UsuarioShortResponse> response = getAllUsuariosUseCase.execute(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioShortResponse> obterPorId(@PathVariable UUID id) {
        UsuarioShortResponse response = getUsuarioByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UsuarioShortResponse> salvar(@RequestBody @Valid UsuarioRequest request) {
        UsuarioShortResponse response = addUsuarioUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody @Valid UsuarioUpdateRequest request) {
        updateUsuarioUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/senha/{id}")
    public ResponseEntity<?> trocarSenha(@PathVariable UUID id, @RequestBody @Valid UsuarioSenhaRequest request) {
        changeSenhaUsuarioUseCase.execute(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> desabilitar(@PathVariable UUID id) {
        disableUsuarioUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
