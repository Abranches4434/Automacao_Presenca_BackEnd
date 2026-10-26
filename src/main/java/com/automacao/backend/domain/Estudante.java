package com.automacao.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false, unique = true)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	private Curso curso;

	@CurrentTimestamp
	private LocalDateTime criadoEm;

	private Boolean status = true;

	@OneToMany(mappedBy = "estudante")
	private List<Matricula> matricula;
}
