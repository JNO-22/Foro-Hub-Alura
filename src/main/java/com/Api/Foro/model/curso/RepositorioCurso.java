package com.Api.Foro.model.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCurso extends JpaRepository<Curso, Long> {
    boolean existeNombre(String nombre);
    Page<Curso> EncontrarActivos(Pageable paginacion);
    Page<Curso> EncontrarNoActivos(Pageable paginacion);
}
