package com.Api.Foro.model.topico;


import com.Api.Foro.model.curso.Curso;
import com.Api.Foro.model.usuario.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private String contenido;
    private LocalDateTime fechaCreacion;
    private Boolean estado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCurso")
    private Curso curso;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario")
    private User usuario;


    public Topico(String titulo,String contenido,User usuario, Curso curso) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.usuario = usuario;
        this.curso = curso;
        this.estado = false;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void actualizar(DataActualizarTopico topico) {
        if (topico.contenido() != null) {
            this.contenido = topico.contenido();
        }
        if (topico.titulo() != null) {
            this.titulo = topico.titulo();
        }
    }

    public void setEstado() {
        this.estado = !estado;
    }

}


