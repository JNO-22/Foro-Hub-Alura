package com.Api.Foro.model.topico;

import jakarta.validation.constraints.NotNull;

public record DataActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String contenido
) {
}
