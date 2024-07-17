package com.Api.Foro.model.topico;

import jakarta.validation.constraints.NotNull;

public record DatoCrearTopico(
        @NotNull
        Long idUsuario,

        @NotNull
        Long idCurso,

        @NotNull
        String titulo,

        @NotNull
        String contenido
) {
}
