package com.Api.Foro.model.topico.respuestas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatoRespuesta(
        @NotNull
        Long id,
        @NotNull
        String contenido,
        @NotNull
        Long idTopico,
        @NotBlank
        Long idAutor
) {

    public DatoRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getContenido(),
                respuesta.getTopico().getId(),
                respuesta.getAutor().getId()
        );
    }
}
