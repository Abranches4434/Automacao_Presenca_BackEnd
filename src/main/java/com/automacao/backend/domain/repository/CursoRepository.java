package com.automacao.backend.domain.repository;

import com.automacao.backend.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID> {
}
