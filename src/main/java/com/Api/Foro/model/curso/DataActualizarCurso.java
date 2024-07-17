package com.Api.Foro.model.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataActualizarCurso(
        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        Categorias categoria
) {
}
