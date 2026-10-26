package com.automacao.backend.application.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.automacao.backend.application.Dto.ProfessorRequestDTO;
import com.automacao.backend.application.Dto.ProfessorResponseDTO;
import com.automacao.backend.domain.Entities.ProfessorEntity;

@Service
public class ProfessorService {

	private static final UUID ID_MOCK = UUID.fromString("22222222-2222-2222-2222-222222222222");

	public ResponseEntity<List<ProfessorResponseDTO>> selecionarTodos() {
		return ResponseEntity.ok(List.of(new ProfessorResponseDTO(criarMock())));
	}

	public ResponseEntity<ProfessorResponseDTO> selecionarPeloId(UUID id) {
		return ResponseEntity.ok(new ProfessorResponseDTO(criarMock()));
	}

	public ResponseEntity<ProfessorResponseDTO> inserir(ProfessorRequestDTO request) {
		ProfessorEntity entity = request.DtoToEntity();
		entity.setId(ID_MOCK);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ProfessorResponseDTO(entity));
	}

	public ResponseEntity<Void> deletar(UUID id) {
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<ProfessorResponseDTO> alterar(UUID id, ProfessorRequestDTO request) {
		ProfessorEntity entity = request.DtoToEntity();
		entity.setId(id);
		return ResponseEntity.ok(new ProfessorResponseDTO(entity));
	}

	private ProfessorEntity criarMock() {
		ProfessorEntity entity = new ProfessorEntity(
				"Carlos Professor",
				"carlos.professor@example.com",
				"11144477735",
				"PROF-001",
				"Engenharia de Software");
		entity.setId(ID_MOCK);
		return entity;
	}
}
