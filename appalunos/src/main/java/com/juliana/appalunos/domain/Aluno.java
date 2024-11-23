package com.juliana.appalunos.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String senha;
    private String nome;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Nota> notas = new ArrayList<>();
}
