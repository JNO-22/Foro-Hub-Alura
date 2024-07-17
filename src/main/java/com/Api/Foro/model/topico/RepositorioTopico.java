package com.Api.Foro.model.topico;

import com.Api.Foro.model.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTopico extends JpaRepository<Topico, Long> {
    Boolean existeTituloYContenido(String titulo, String contenido);
    void borrarPorId(Long id);
    Page<Topico> EncontrarTodos(Curso curso, Pageable paginacion);
    Page<Topico> EncontrarActivos(Pageable paginacion);
    Page<Topico> EncontrarNotActivos(Pageable paginacion);
}
