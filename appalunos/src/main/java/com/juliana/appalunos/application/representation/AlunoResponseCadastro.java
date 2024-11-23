package com.juliana.appalunos.application.representation;

import lombok.Data;

@Data
public class AlunoResponseCadastro {
    private Long id;
    private String email;
    private String nome;
}
