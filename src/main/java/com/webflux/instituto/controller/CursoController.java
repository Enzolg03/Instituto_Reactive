package com.webflux.instituto.controller;

import com.webflux.instituto.entity.bd.Curso;
import com.webflux.instituto.entity.dto.CursoEstudiantesDTO;
import com.webflux.instituto.entity.dto.EstudianteCursoDTO;
import com.webflux.instituto.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @PostMapping("/registrar")
    public Mono<Curso> registrarCurso(@RequestBody Curso curso){
        return cursoService.registrarCurso(curso);
    }
    @PutMapping("/actualizar/{curso_id}")
    public Mono<Curso> actualizarCurso(@PathVariable Long curso_id, @RequestBody Curso curso){
        return cursoService.actualizarCurso(curso_id,curso);
    }
    @DeleteMapping("/eliminar/{curso_id}")
    public Mono<Void> eliminarCurso(@PathVariable Long curso_id){
        return cursoService.eliminarCurso(curso_id);
    }
    @GetMapping("/estudianteCurso")
    public Flux<CursoEstudiantesDTO> obtenerCursosEstudiantes() {
        return cursoService.obtenerCursosEstudiantes();
    }
    @GetMapping("/curso_id/{curso_id}")
    public Mono<CursoEstudiantesDTO> obtenerCursoEstudiantesPorId(@PathVariable Long curso_id) {
        return cursoService.obtenerCursoEstudiantesPorId(curso_id);
    }
}
