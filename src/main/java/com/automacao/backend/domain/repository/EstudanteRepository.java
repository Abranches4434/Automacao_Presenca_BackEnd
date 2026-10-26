package com.automacao.backend.domain.repository;

import com.automacao.backend.domain.Estudante;
import com.automacao.backend.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, UUID> {
    boolean existsByUsuario(Usuario usuario);
}
