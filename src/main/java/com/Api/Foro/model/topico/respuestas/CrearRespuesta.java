package com.Api.Foro.model.topico.respuestas;

public record CrearRespuesta(
        String contenido,
        Long idTopico,
        Long idAutor
) {
}
