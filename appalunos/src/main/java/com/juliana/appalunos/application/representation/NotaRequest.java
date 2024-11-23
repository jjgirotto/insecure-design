package com.juliana.appalunos.application.representation;

import lombok.Data;

@Data
public class NotaRequest {
    private Long idAluno;
    private String tipo;
    private Double valor;
}
