package com.automacao.backend.domain.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automacao.backend.domain.Entities.ProfessorEntity;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, UUID> {
}
