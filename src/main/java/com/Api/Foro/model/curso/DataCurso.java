package com.Api.Foro.model.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCurso(
        @NotBlank
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        Categorias categoria,
        @NotNull
        Boolean Estado
) {
    public DataCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria(),
                curso.getEstado()
        );
    }
}
