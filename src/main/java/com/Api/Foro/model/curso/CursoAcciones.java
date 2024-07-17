package com.Api.Foro.model.curso;

import com.Api.Foro.model.topico.DataTopico;
import com.Api.Foro.model.topico.RepositorioTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CursoAcciones {
    @Autowired
    private RepositorioCurso repositorioCurso;
    @Autowired
    private RepositorioTopico repositorioTopico;

    public DataCurso crearCurso(DataCrearCurso data) {
        if (repositorioCurso.existeNombre(data.nombre())){
            throw new IllegalStateException("Ya existe un curso con ese nombre");
        }
        var curso = new Curso(data.nombre(), data.categoria());
        repositorioCurso.save(curso);
        return new DataCurso(curso);
    }

    public DataCurso actualizarCurso(DataActualizarCurso data) {
        existeCurso(data.id());
        var curso = repositorioCurso.getReferenceById(data.id());
        curso.actualizar(data);
        return new DataCurso(curso);
    }

    public DataCurso cambiarEstado(Long id) {
        existeCurso(id);
        var curso = repositorioCurso.findById(id).orElseThrow();
        curso.setEstado();
        return new DataCurso(curso);
    }

    private void existeCurso(Long id){
        if(id == null){
            throw new IllegalStateException("El id no puede ser nulo");
        }
        if (!repositorioCurso.existsById(id)){
            throw new IllegalStateException("El curso no existe");
        }
    }

    public Page<DataCurso> encontrarActivos(Pageable paginacion){
        return repositorioCurso.EncontrarActivos(paginacion).map(DataCurso::new);
    }

    public Page<DataCurso> encontrarNoActivos(Pageable paginacion){
        return repositorioCurso.EncontrarNoActivos(paginacion).map(DataCurso::new);
    }
    public Page<DataCurso> Listar(Pageable paginacion){
        return repositorioCurso.findAll(paginacion).map(DataCurso::new);
    }

    public DatoTopicoCurso mostrar(Long id , Pageable paginacion){
        existeCurso(id);
        var curso = repositorioCurso.getReferenceById(id);
        var topicos = repositorioTopico.EncontrarTodos(curso,paginacion).map(DataTopico::new);
        return new DatoTopicoCurso(new DataCurso(curso),topicos);
    }
}
