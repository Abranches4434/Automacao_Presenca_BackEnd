package com.automacao.backend.application.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.automacao.backend.application.Dto.ProfessorRequestDTO;
import com.automacao.backend.application.Dto.ProfessorResponseDTO;
import com.automacao.backend.application.Service.ProfessorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

	private final ProfessorService professorService;

	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}

	@GetMapping
	public ResponseEntity<List<ProfessorResponseDTO>> selecionarTodos() {
		return professorService.selecionarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProfessorResponseDTO> selecionarPeloId(@PathVariable UUID id) {
		return professorService.selecionarPeloId(id);
	}

	@PostMapping
	public ResponseEntity<ProfessorResponseDTO> inserir(
			@Valid @RequestBody ProfessorRequestDTO request) {
		return professorService.inserir(request);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable UUID id) {
		return professorService.deletar(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProfessorResponseDTO> alterar(
			@PathVariable UUID id,
			@Valid @RequestBody ProfessorRequestDTO request) {
		return professorService.alterar(id, request);
	}
}
