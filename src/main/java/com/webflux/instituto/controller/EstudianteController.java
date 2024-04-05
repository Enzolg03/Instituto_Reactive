package com.webflux.instituto.controller;

import com.webflux.instituto.entity.bd.Estudiante;
import com.webflux.instituto.entity.dto.EstudianteCursoDTO;
import com.webflux.instituto.entity.dto.EstudianteDTO;
import com.webflux.instituto.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;
    @PostMapping("/registrar")
    public Mono<Estudiante> registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.registrarEstudiante(estudianteDTO);
    }
    @PutMapping("/actualizar/{estudiante_id}")
    public Mono<Estudiante> actualizarEstudiante(@PathVariable Long estudiante_id, @RequestBody Estudiante estudiante){
        return estudianteService.actualizarEstudiante(estudiante_id,estudiante);
    }
    @DeleteMapping("/eliminar/{estudiante_id}")
    public Mono<Void> eliminarEstudiante(@PathVariable Long estudiante_id){
        return estudianteService.eliminarEstudiante(estudiante_id);
    }
    @GetMapping("/edad/{edad}")
    public Flux<Estudiante> obtenerEstudiantesXEdad(@PathVariable int edad){
        return estudianteService.obtenerEstudiantesXEdad(edad);
    }
    @PutMapping("/{curso}/asignar-curso/{estudinate_id}")
    public Mono<Void> asignarCurso(@PathVariable("estudinate_id") Long estudinate_id,
                                            @PathVariable("curso") Long curso) {
        return estudianteService.asignarCurso(estudinate_id,curso);
    }
    @GetMapping("/{estudianteId}/curso")
    public Flux<EstudianteCursoDTO> obtenerDetallesEstudianteCurso(@PathVariable Long estudianteId) {
        return estudianteService.obtenerDetallesEstudianteCurso(estudianteId);
    }
}
