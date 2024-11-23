package com.juliana.appalunos.application.controller;

import com.juliana.appalunos.application.representation.AlunoCadastroRequest;
import com.juliana.appalunos.application.representation.AlunoRequest;
import com.juliana.appalunos.application.representation.AlunoResponse;
import com.juliana.appalunos.application.representation.AlunoResponseCadastro;
import com.juliana.appalunos.application.services.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponseCadastro> cadastrarAluno(@RequestBody @Valid AlunoCadastroRequest request) {
        AlunoResponseCadastro aluno = alunoService.cadastrarAluno(request);
        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    @GetMapping("/notas")
    public ResponseEntity<AlunoResponse> buscarNotas(@RequestBody AlunoRequest request) {
        AlunoResponse response = alunoService.buscarNotasPorAluno(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/notas/{tipo}")
    public ResponseEntity<AlunoResponse> buscarNotas(
            @PathVariable(value = "tipo") String tipo,
            @RequestBody AlunoRequest request) {
        AlunoResponse response = alunoService.buscarNotasAlunoPorTipo(tipo, request);
        return ResponseEntity.ok(response);
    }
}
