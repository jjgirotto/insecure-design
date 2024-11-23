package com.juliana.appalunos.application.services;

import com.juliana.appalunos.application.representation.NotaRequest;
import com.juliana.appalunos.application.representation.mapper.NotaMapper;
import com.juliana.appalunos.domain.Aluno;
import com.juliana.appalunos.domain.Nota;
import com.juliana.appalunos.repositories.AlunoRepository;
import com.juliana.appalunos.repositories.NotaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;
    private final AlunoRepository alunoRepository;
    private final NotaMapper notaMapper;

    public void cadastrarNota(NotaRequest request) {
        Aluno aluno = alunoRepository.findById(request.getIdAluno()).orElseThrow(
                () -> new EntityNotFoundException()
        );
        Nota nota = notaMapper.converterRequestParaEntidade(request);
        nota.setAluno(aluno);
        notaRepository.save(nota);
    }
}
