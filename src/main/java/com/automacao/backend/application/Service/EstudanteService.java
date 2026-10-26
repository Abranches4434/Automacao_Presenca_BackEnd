package com.automacao.backend.application.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.automacao.backend.application.Dto.EstudanteRequestDTO;
import com.automacao.backend.application.Dto.EstudanteResponseDTO;

public interface EstudanteService {

	ResponseEntity<List<EstudanteResponseDTO>> selecionarTodos();

	ResponseEntity<EstudanteResponseDTO> selecionarPeloId(UUID id);

	ResponseEntity<EstudanteResponseDTO> inserir(EstudanteRequestDTO request);

	ResponseEntity<Void> deletar(UUID id);

	ResponseEntity<EstudanteResponseDTO> alterar(UUID id, EstudanteRequestDTO request);
}
