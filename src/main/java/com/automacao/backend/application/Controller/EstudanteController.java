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

import com.automacao.backend.application.Dto.EstudanteRequestDTO;
import com.automacao.backend.application.Dto.EstudanteResponseDTO;
import com.automacao.backend.application.Service.EstudanteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

	private final EstudanteService estudanteService;

	public EstudanteController(EstudanteService estudanteService) {
		this.estudanteService = estudanteService;
	}

	@GetMapping
	public ResponseEntity<List<EstudanteResponseDTO>> selecionarTodos() {
		return estudanteService.selecionarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstudanteResponseDTO> selecionarPeloId(@PathVariable UUID id) {
		return estudanteService.selecionarPeloId(id);
	}

	@PostMapping
	public ResponseEntity<EstudanteResponseDTO> inserir(
			@Valid @RequestBody EstudanteRequestDTO request) {
		return estudanteService.inserir(request);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable UUID id) {
		return estudanteService.deletar(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EstudanteResponseDTO> alterar(
			@PathVariable UUID id,
			@Valid @RequestBody EstudanteRequestDTO request) {
		return estudanteService.alterar(id, request);
	}
}
