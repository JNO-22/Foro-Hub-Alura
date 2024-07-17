package com.Api.Foro.model.curso;

import jakarta.validation.constraints.NotNull;

public record DataCrearCurso(
    @NotNull
    String nombre,
    @NotNull
    Categorias categoria){
}
