package com.Api.Foro.model.topico;

import java.time.LocalDateTime;

public record DataTopico(
        Long id,
        String titulo,
        String contenido,
        LocalDateTime fechaCreacion,
        Boolean estado,
        String Usuario,
        String Curso) {
    public DataTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getContenido(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getUsuario().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}
