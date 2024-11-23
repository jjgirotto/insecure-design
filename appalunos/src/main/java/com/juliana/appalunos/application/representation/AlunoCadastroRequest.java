package com.juliana.appalunos.application.representation;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlunoCadastroRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String nome;
}
