package com.automacao.backend.domain.repository;

import com.automacao.backend.domain.Professor;
import com.automacao.backend.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
    boolean existsByUsuario(Usuario usuario);
}
