package com.Api.Foro.model.curso;

import com.Api.Foro.model.topico.DataTopico;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;

public record DatoTopicoCurso(
        @NotNull
        DataCurso curso,
        @NotNull
        Page<DataTopico> topicos
) {
}
