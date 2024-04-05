package com.webflux.instituto.service;

import com.webflux.instituto.entity.bd.Curso;
import com.webflux.instituto.entity.dto.CursoEstudiantesDTO;
import com.webflux.instituto.entity.dto.EstudianteCursoDTO;
import com.webflux.instituto.repo.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoService {
    @Autowired
    private CursoRepo cursoRepo;

    public Mono<Curso> registrarCurso(Curso curso){
        return cursoRepo.save(curso);
    }
    public Mono<Curso> actualizarCurso(Long curso_id, Curso curso){
        return cursoRepo.findById(curso_id).map(
                (c) -> {
                    c.setNombre(curso.getNombre());
                    c.setProfesor(curso.getProfesor());
                    c.setDescripcion(curso.getDescripcion());
                    return c;
                }
        ).flatMap(c-> cursoRepo.save(c));
    }
    public Mono<Void> eliminarCurso(Long curso_id){
        return cursoRepo.deleteById(curso_id);
    }

    public Flux<CursoEstudiantesDTO> obtenerCursosEstudiantes(){
        return cursoRepo.obtenerCursosEstudiantes();
    }
    public Mono<CursoEstudiantesDTO> obtenerCursoEstudiantesPorId(Long curso_id){
        return cursoRepo.obtenerCursoEstudiantesPorId(curso_id);
    };
}
