package com.automacao.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @Column(nullable = false, length = 200)
    private String descricao;

    @CurrentTimestamp
    private LocalDateTime criadoEm;

    private Boolean status = true;

    @OneToMany(mappedBy = "curso")
    private List<Estudante> estudantes;
}
