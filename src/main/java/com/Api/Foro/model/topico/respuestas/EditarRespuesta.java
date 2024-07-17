package com.Api.Foro.model.topico.respuestas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EditarRespuesta(

        @NotBlank
        Long idAutor,
        @NotNull
        String contenido
) {
}
