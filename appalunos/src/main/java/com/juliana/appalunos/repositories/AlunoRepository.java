package com.juliana.appalunos.repositories;

import com.juliana.appalunos.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByEmail(String email);
}
