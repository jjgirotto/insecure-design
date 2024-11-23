package com.juliana.appalunos.repositories;

import com.juliana.appalunos.domain.Aluno;
import com.juliana.appalunos.domain.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findAllByAluno(Aluno aluno);
}
