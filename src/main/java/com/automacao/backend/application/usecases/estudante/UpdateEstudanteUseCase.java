package com.automacao.backend.application.usecases.estudante;

import com.automacao.backend.application.dto.estudante.EstudanteRequest;
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

import java.util.UUID;

@AllArgsConstructor
@Service
public class UpdateEstudanteUseCase {
    private final EstudanteRepository estudanteRepository;
    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public void execute(UUID id, EstudanteRequest request) {
        Estudante estudante = estudanteRepository.findById(id).orElseThrow(
            () -> new NotFoundException("Estudante não encontrado.")
        );

        Usuario usuario = usuarioRepository.findById(request.usuarioId()).orElseThrow(
                () -> new NotFoundException("Usuário não encontrado.")
        );

        Curso curso = cursoRepository.findById(request.cursoId()).orElseThrow(
                () -> new NotFoundException("Curso não encontrado.")
        );

        estudante.setCurso(curso);
        estudante.setUsuario(usuario);

        estudanteRepository.save(estudante);
    }
}
