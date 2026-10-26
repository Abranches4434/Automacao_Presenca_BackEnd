package com.automacao.backend.domain.repository;

import com.automacao.backend.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, UUID> {
    boolean existsByCodigo(String codigo);
    boolean existsByCodigoAndIdNot(String codigo, UUID id);
}
