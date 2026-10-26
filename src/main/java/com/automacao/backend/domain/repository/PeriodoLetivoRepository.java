package com.automacao.backend.domain.repository;

import com.automacao.backend.domain.PeriodoLetivo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PeriodoLetivoRepository extends JpaRepository<PeriodoLetivo, UUID> {
    boolean existsByNome(String nome);
    boolean existsByNomeAndIdNot(String nome, UUID id);
}
