package com.automacao.backend.application.usecases.professor;

import com.automacao.backend.application.dto.professor.ProfessorRequest;
import com.automacao.backend.application.dto.professor.ProfessorShortResponse;
import com.automacao.backend.application.infrastructure.exception.DataAlreadyRegistered;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Professor;
import com.automacao.backend.domain.Usuario;
import com.automacao.backend.domain.repository.ProfessorRepository;
import com.automacao.backend.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UpdateProfessorUseCase {
    private final ProfessorRepository professorRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public void execute(UUID id, ProfessorRequest request) {
        Professor professor = professorRepository.findById(id).orElseThrow(
            () -> new NotFoundException("Professor não encontrado.")
        );

        Usuario usuario = usuarioRepository.findById(request.userId()).orElseThrow(
                () -> new NotFoundException("Usuário não encontrado.")
        );

        validated(usuario);

        professor.setUsuario(usuario);
        professor.setRegistro(request.registro());
        professor.setDepartamento(request.departamento());

        professorRepository.save(professor);
    }

    private void validated(Usuario usuario) {
        if (professorRepository.existsByUsuario(usuario))
            throw new DataAlreadyRegistered("O usuário vinculado ao estudante já possui cadastrado.");
    }
}
