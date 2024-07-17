package com.Api.Foro.controller;

import com.Api.Foro.model.topico.respuestas.CrearRespuesta;
import com.Api.Foro.model.topico.respuestas.EditarRespuesta;
import com.Api.Foro.model.topico.respuestas.RespuestaAcciones;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class ResponseController {

    @Autowired
    private RespuestaAcciones service;

    @PostMapping
    @Transactional
    public ResponseEntity crearRespuesta(
            @RequestBody
            @Valid
            CrearRespuesta datos){
        var response = service.crearRespuesta(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarRespuesta(
            @RequestBody
            @Valid
            EditarRespuesta datos){
        var response = service.editarRespuesta(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(
            @PathVariable
            Long id){
        service.borrarRespuesta(id);
        return ResponseEntity.ok().build();
    }
}











