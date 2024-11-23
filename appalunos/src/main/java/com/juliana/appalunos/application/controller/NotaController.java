package com.juliana.appalunos.application.controller;

import com.juliana.appalunos.application.representation.NotaRequest;
import com.juliana.appalunos.application.services.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @PostMapping
    public ResponseEntity<Void> cadastrarNota(@RequestBody NotaRequest request) {
        notaService.cadastrarNota(request);
        return ResponseEntity.noContent().build();
    }
}
