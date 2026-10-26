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

@AllArgsConstructor
@Service
public class AddProfessorUseCase {
    private final ProfessorRepository professorRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public ProfessorShortResponse execute(ProfessorRequest request) {
        Usuario usuario = usuarioRepository.findById(request.userId()).orElseThrow(
            () -> new NotFoundException("Usuário não encontrado.")
        );

        validated(usuario);

        Professor professor = new Professor();

        professor.setUsuario(usuario);
        professor.setRegistro(request.registro());
        professor.setDepartamento(request.departamento());

        professorRepository.save(professor);

        return ProfessorShortResponse.fromEntity(professor);
    }

    private void validated(Usuario usuario) {
        if (professorRepository.existsByUsuario(usuario))
            throw new DataAlreadyRegistered("O usuário vinculado ao estudante já possui cadastrado.");
    }
}
