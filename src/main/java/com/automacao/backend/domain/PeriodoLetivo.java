package com.automacao.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class PeriodoLetivo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 20)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @CurrentTimestamp
    private LocalDateTime criadoEm;

    private Boolean status = true;
}
