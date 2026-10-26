package com.automacao.backend.application.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.automacao.backend.application.Dto.ProfessorRequestDTO;
import com.automacao.backend.application.Dto.ProfessorResponseDTO;

public interface ProfessorService {

	ResponseEntity<List<ProfessorResponseDTO>> selecionarTodos();

	ResponseEntity<ProfessorResponseDTO> selecionarPeloId(UUID id);

	ResponseEntity<ProfessorResponseDTO> inserir(ProfessorRequestDTO request);

	ResponseEntity<Void> deletar(UUID id);

	ResponseEntity<ProfessorResponseDTO> alterar(UUID id, ProfessorRequestDTO request);
}
