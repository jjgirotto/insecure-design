package com.juliana.appalunos.application.representation.mapper;

import com.juliana.appalunos.application.representation.AlunoCadastroRequest;
import com.juliana.appalunos.application.representation.AlunoRequest;
import com.juliana.appalunos.application.representation.AlunoResponse;
import com.juliana.appalunos.application.representation.AlunoResponseCadastro;
import com.juliana.appalunos.domain.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    Aluno converterCadastroRequestParaEntidade (AlunoCadastroRequest cadastroRequest);
    AlunoResponse converterAlunoParaResponse (Aluno aluno);

    AlunoResponseCadastro converterAlunoParaResponseCadastro(Aluno aluno);
}
