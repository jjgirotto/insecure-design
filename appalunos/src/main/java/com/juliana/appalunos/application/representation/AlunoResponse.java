package com.juliana.appalunos.application.representation;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class AlunoResponse {
    private String email;
    private String nome;
    private List<NotaResponse> notas = new ArrayList<>();
}
