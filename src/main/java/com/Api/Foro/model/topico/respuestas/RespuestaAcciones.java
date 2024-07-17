package com.Api.Foro.model.topico.respuestas;

import com.Api.Foro.model.topico.RepositorioTopico;
import com.Api.Foro.model.usuario.RepositorioUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaAcciones {
    @Autowired
    private RepositorioRespuesta repositorioRespuesta;
    @Autowired
    private RepositorioTopico repositorioTopico;
    @Autowired
    private RepositorioUser repositorioUser;

    public DatoRespuesta crearRespuesta(CrearRespuesta data) {
        var contenido = data.contenido();
        var autor = repositorioUser.getReferenceById(data.idAutor());
        var topico = repositorioTopico.getReferenceById(data.idTopico());
        var respuesta = new Respuesta(contenido, autor, topico);
        repositorioRespuesta.save(respuesta);
        return new DatoRespuesta(respuesta);
    }

    public void borrarRespuesta(Long id) {
        existeId(id);
        var idTopico = repositorioRespuesta.getReferenceById(id).getTopico().getId();
        var topico = repositorioTopico.getReferenceById(idTopico);
        repositorioRespuesta.deleteById(id);
    }

    public DatoRespuesta editarRespuesta(EditarRespuesta data) {
        if (data.contenido() == null){
            throw new IllegalStateException("El contenido no puede ser nulo");
        }
        if (!repositorioRespuesta.existsById(data.idAutor())){
            throw new IllegalStateException("La respuesta no existe con el id: " + data.idAutor());
        }
        var respuesta = repositorioRespuesta.getReferenceById(data.idAutor());
        respuesta.actualizarContenido(data.contenido());
        return new DatoRespuesta(respuesta);

    }

    private void existeId(Long id){
        if(id == null){
            throw new IllegalStateException("El id no puede ser nulo");
        }
        if (!repositorioRespuesta.existsById(id)){
            throw new IllegalStateException("La respuesta no existe con el id: " + id);
        }
    }

}
