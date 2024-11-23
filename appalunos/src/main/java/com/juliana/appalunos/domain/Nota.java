package com.juliana.appalunos.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "notas")
@NoArgsConstructor
@AllArgsConstructor
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
}
