package com.automacao.backend.application.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.automacao.backend.application.Dto.EstudanteRequestDTO;
import com.automacao.backend.application.Dto.EstudanteResponseDTO;
import com.automacao.backend.domain.Entities.EstudanteEntity;

@Service
public class EstudanteService {

	private static final UUID ID_MOCK = UUID.fromString("11111111-1111-1111-1111-111111111111");

	public ResponseEntity<List<EstudanteResponseDTO>> selecionarTodos() {
		return ResponseEntity.ok(List.of(new EstudanteResponseDTO(criarMock())));
	}

	public ResponseEntity<EstudanteResponseDTO> selecionarPeloId(UUID id) {
		return ResponseEntity.ok(new EstudanteResponseDTO(criarMock()));
	}

	public ResponseEntity<EstudanteResponseDTO> inserir(EstudanteRequestDTO request) {
		EstudanteEntity entity = request.DtoToEntity();
		entity.setId(ID_MOCK);
		return ResponseEntity.status(HttpStatus.CREATED).body(new EstudanteResponseDTO(entity));
	}

	public ResponseEntity<Void> deletar(UUID id) {
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<EstudanteResponseDTO> alterar(UUID id, EstudanteRequestDTO request) {
		EstudanteEntity entity = request.DtoToEntity();
		entity.setId(id);
		return ResponseEntity.ok(new EstudanteResponseDTO(entity));
	}

	private EstudanteEntity criarMock() {
		EstudanteEntity entity = new EstudanteEntity(
				"Ana Estudante",
				"ana.estudante@example.com",
				"52998224725",
				"20260001",
				"Ciência da Computação");
		entity.setId(ID_MOCK);
		return entity;
	}
}
