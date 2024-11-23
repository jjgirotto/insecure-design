package com.juliana.appalunos.application.services;

import com.juliana.appalunos.application.representation.*;
import com.juliana.appalunos.application.representation.mapper.AlunoMapper;
import com.juliana.appalunos.application.representation.mapper.NotaMapper;
import com.juliana.appalunos.domain.Aluno;
import com.juliana.appalunos.domain.Nota;
import com.juliana.appalunos.repositories.AlunoRepository;
import com.juliana.appalunos.repositories.NotaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final NotaRepository notaRepository;
    private final AlunoMapper alunoMapper;
    private final NotaMapper notaMapper;

    public AlunoResponseCadastro cadastrarAluno(AlunoCadastroRequest cadastroRequest) {
        Aluno aluno = alunoMapper.converterCadastroRequestParaEntidade(cadastroRequest);
        alunoRepository.save(aluno);
        return alunoMapper.converterAlunoParaResponseCadastro(aluno);
    }

    public AlunoResponse buscarNotasPorAluno(AlunoRequest request) {
        Aluno aluno = validarLoginERetornarAluno(request);
        List<Nota> notas = notaRepository.findAllByAluno(aluno);
        aluno.setNotas(notas);
        return alunoMapper.converterAlunoParaResponse(aluno);
    }

    public AlunoResponse buscarNotasAlunoPorTipo(String tipo, AlunoRequest request) {
        Aluno aluno = validarLoginERetornarAluno(request);
        List<NotaResponse> notasPorTipo = notaRepository.findAllByAluno(aluno)
                .stream()
                .filter(nota -> Objects.equals(nota.getTipo(), tipo))
                .map(notaMapper::converterParaNotaResponse)
                .toList();
        AlunoResponse response = alunoMapper.converterAlunoParaResponse(aluno);
        response.setNotas(notasPorTipo);
        return response;
    }

    private Aluno validarLoginERetornarAluno(AlunoRequest request) {
        if (checarLogin(request))
            return buscarAlunoPorEmail(request.getEmail());
        return null;
    }

    private boolean checarLogin(AlunoRequest request) {
        try {
            Aluno aluno = buscarAlunoPorEmail(request.getEmail());
            return Objects.equals(request.getSenha(), aluno.getSenha());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private Aluno buscarAlunoPorEmail(String email) {
        Aluno aluno = alunoRepository.findByEmail(email);
        if (aluno == null) throw new EntityNotFoundException();
        return aluno;
    }
}
