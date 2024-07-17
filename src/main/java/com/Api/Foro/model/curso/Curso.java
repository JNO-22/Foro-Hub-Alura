package com.Api.Foro.model.curso;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cursos")
@Entity(name = "curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private String nombre;
    private Boolean estado;
    @Getter
    @Enumerated(EnumType.STRING)
    private Categorias categoria;

    public Curso(String nombre, Categorias categoria) {
        this.estado = true;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Curso(DataCurso data) {
        this.id = data.id();
        this.nombre = data.nombre();
        this.categoria = data.categoria();
        this.estado = data.Estado();
    }

    public void actualizar(DataActualizarCurso data) {
      if (data.nombre() != null) {
          this.nombre = data.nombre();
      }
      if (data.categoria()!= null) {
          this.categoria = data.categoria();
      }
    }

    public void setEstado(){
        this.estado = !estado;
    }
}
