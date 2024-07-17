package com.Api.Foro.model.topico;

import com.Api.Foro.model.topico.respuestas.DatoRespuesta;
import org.springframework.data.domain.Page;

public record DatoRespuestaTopico(
        DataTopico topico,
        Page<DatoRespuesta> respuestas
) {
}
