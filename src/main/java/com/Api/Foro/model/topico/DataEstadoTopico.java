package com.Api.Foro.model.topico;

import com.Api.Foro.model.topico.respuestas.DatoRespuesta;

public record DataEstadoTopico(
        DataTopico topico,
        DatoRespuesta respuesta
) {
}
