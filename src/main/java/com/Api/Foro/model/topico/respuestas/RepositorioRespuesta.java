package com.Api.Foro.model.topico.respuestas;

import com.Api.Foro.model.topico.Topico;
import com.Api.Foro.model.usuario.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRespuesta extends JpaRepository<Respuesta, Long> {

    boolean existeTopico(Topico topico);

    boolean existeTopicoContenidoYAutor(Topico topico, String contenido, User autor);
    Page<Respuesta> encontrarPorTopico(Topico topico, Pageable paginacion);
    void borrarPorTopico(Topico topicoId);
}
