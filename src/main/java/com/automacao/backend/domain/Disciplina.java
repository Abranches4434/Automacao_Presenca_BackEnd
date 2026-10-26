package com.automacao.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 1000)
    private String ementa;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @CurrentTimestamp
    private LocalDateTime criadoEm;

    private Boolean status = true;
}
