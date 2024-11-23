package com.juliana.appalunos.application.representation.mapper;

import com.juliana.appalunos.application.representation.NotaRequest;
import com.juliana.appalunos.application.representation.NotaResponse;
import com.juliana.appalunos.domain.Nota;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotaMapper {

    NotaResponse converterParaNotaResponse(Nota nota);
    Nota converterRequestParaEntidade(NotaRequest notaRequest);
}
