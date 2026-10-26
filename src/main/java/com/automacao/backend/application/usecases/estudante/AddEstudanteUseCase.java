package com.automacao.backend.application.usecases.estudante;

import com.automacao.backend.application.dto.estudante.EstudanteRequest;
import com.automacao.backend.application.dto.estudante.EstudanteShortResponse;
import com.automacao.backend.application.infrastructure.exception.DataAlreadyRegistered;
import com.automacao.backend.application.infrastructure.exception.NotFoundException;
import com.automacao.backend.domain.Curso;
import com.automacao.backend.domain.Estudante;
import com.automacao.backend.domain.Usuario;
import com.automacao.backend.domain.repository.CursoRepository;
import com.automacao.backend.domain.repository.EstudanteRepository;
import com.automacao.backend.domain.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddEstudanteUseCase {
    private final EstudanteRepository estudanteRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Transactional
    public EstudanteShortResponse execute(EstudanteRequest request) {
        Usuario usuario = usuarioRepository.findById(request.usuarioId()).orElseThrow(
            () -> new NotFoundException("Usuário não encontrado.")
        );

        validated(usuario);

        Curso curso = cursoRepository.findById(request.cursoId()).orElseThrow(
            () -> new NotFoundException("Curso não encontrado.")
        );

        Estudante estudante = new Estudante();

        estudante.setUsuario(usuario);
        estudante.setCurso(curso);

        estudanteRepository.save(estudante);

        return EstudanteShortResponse.fromEntity(estudante);
    }

    private void validated(Usuario usuario) {
        if (estudanteRepository.existsByUsuario(usuario))
            throw new DataAlreadyRegistered("O usuário vinculado ao estudante já possui cadastrado.");
    }
}
