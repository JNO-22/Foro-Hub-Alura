package com.Api.Foro.model.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticarUser(@NotBlank
                                  @Email
                                  String email,

                                  @NotBlank
                                  String contrasena) {
}
