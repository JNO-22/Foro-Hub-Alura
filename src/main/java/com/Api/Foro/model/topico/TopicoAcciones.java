package com.Api.Foro.model.topico;

import com.Api.Foro.model.curso.RepositorioCurso;
import com.Api.Foro.model.topico.respuestas.DatoRespuesta;
import com.Api.Foro.model.topico.respuestas.RepositorioRespuesta;
import com.Api.Foro.model.usuario.RepositorioUser;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoAcciones {
    @Autowired
    private RepositorioTopico repositorioTopico;
    @Autowired
    private RepositorioRespuesta repositorioRespuesta;
    @Autowired
    private RepositorioUser repositorioUsuario;
    @Autowired
    private RepositorioCurso repositorioCurso;

    public DataTopico crearTopico(DatoCrearTopico data){
        var titulo = data.titulo();
        var contenido = data.contenido();
        var autor = repositorioUsuario.getReferenceById(data.idUsuario());
        var curso = repositorioCurso.getReferenceById(data.idCurso());
        var topico = new Topico(titulo,contenido,autor,curso);
        repositorioTopico.save(topico);
        return new DataTopico(topico);
    }

    public DataTopico actualizarTopico(DataActualizarTopico data){
        var topico = repositorioTopico.getReferenceById(data.id());
        topico.actualizar(data);
        return new DataTopico(topico);
    }

    public String eliminarTopico(Long id){
        var topico = repositorioTopico.findById(id);
        if (topico.isEmpty()){
            throw new ValidationException("No se encontro el topico con el id: "+id);
        }
        repositorioRespuesta.borrarPorTopico(repositorioTopico.getReferenceById(id));
        repositorioTopico.deleteById(id);
        return "Se elimino el topico con el id: "+id;
    }

    public Page<DataTopico> listarTopicos(Pageable paginacion){
        return repositorioTopico.findAll(paginacion).map(DataTopico::new);
    }

    public DatoRespuestaTopico mostrarTopico(Long id , Pageable paginacion){
        if (id == null || !repositorioTopico.existsById(id)){
            throw new ValidationException("No se encontro el topico con el id: "+id);
        }
        var topico = repositorioTopico.getReferenceById(id);
        var respuestas = repositorioRespuesta.encontrarPorTopico(topico, paginacion)
                .map(DatoRespuesta::new);
        return new DatoRespuestaTopico(new DataTopico(topico), respuestas);
    }

    public Page<DataTopico> listarTopicosResueltos(Pageable paginacion){
        return repositorioTopico.EncontrarActivos(paginacion).map(DataTopico::new);
    }

    public Page<DataTopico> listarTopicosNoResueltos(Pageable paginacion){
        return repositorioTopico.EncontrarNotActivos(paginacion).map(DataTopico::new);
    }



}
