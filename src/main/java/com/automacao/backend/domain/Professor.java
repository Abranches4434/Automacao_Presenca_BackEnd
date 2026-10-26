package com.automacao.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false, unique = true)
	private Usuario usuario;

	@Column(nullable = false, unique = true, length = 20)
	private String registro;

	@Column(length = 100)
	private String departamento;

	@CurrentTimestamp
	private LocalDateTime criadoEm;

	private Boolean status = true;
}
