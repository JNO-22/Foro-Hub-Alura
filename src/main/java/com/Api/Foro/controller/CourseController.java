package com.Api.Foro.controller;

import com.Api.Foro.model.curso.CursoAcciones;
import com.Api.Foro.model.curso.DataActualizarCurso;
import com.Api.Foro.model.curso.DataCrearCurso;
import com.Api.Foro.model.curso.DataCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CourseController {

    @Autowired
    private CursoAcciones service;

    @PostMapping
    @Transactional
    public ResponseEntity crearCurso(
            @RequestBody
            @Valid
            DataCrearCurso datos){
        var response = service.crearCurso(datos);
        return ResponseEntity.ok(response);
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(
            @RequestBody
            @Valid
            DataActualizarCurso datos){
        var response = service.actualizarCurso(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cambiarEstadoCurso(
            @PathVariable
            Long id){
        service.cambiarEstado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/activos")
    public ResponseEntity<Page<DataCurso>> listarCursos(
            @PageableDefault(size=10)
            Pageable paginacion){
        var response = service.encontrarActivos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<Page<DataCurso>> listarCursosInactivos(
            @PageableDefault(size=10)
            Pageable paginacion){
                var response = service.encontrarNoActivos(paginacion);
                return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DataCurso>> listarCurso(@PageableDefault(size = 10) Pageable paginacion){
        var response = service.Listar(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarCurso(
            @PageableDefault(size = 10)
            Pageable paginacion,
            @PathVariable
            @Valid
            Long id){
        var response = service.mostrar(id, paginacion);
        return ResponseEntity.ok(response);
    }
}