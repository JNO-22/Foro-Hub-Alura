package com.Api.Foro.model.topico.respuestas;

import com.Api.Foro.model.topico.Topico;
import com.Api.Foro.model.usuario.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contenido;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTopico")
    private Topico topico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAutor")
    private User autor;

    public Respuesta(String contenido, User autor, Topico topico) {
        this.contenido = contenido;
        this.autor = autor;
        this.topico = topico;
        this.fechaCreacion = LocalDateTime.now();
    }
    public void actualizarContenido(String contenido) {
        this.contenido = contenido;
    }
}
