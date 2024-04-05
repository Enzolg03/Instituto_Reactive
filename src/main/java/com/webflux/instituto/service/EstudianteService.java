package com.webflux.instituto.service;

import com.webflux.instituto.entity.bd.Estudiante;
import com.webflux.instituto.entity.dto.CursoEstudiantesDTO;
import com.webflux.instituto.entity.dto.EstudianteCursoDTO;
import com.webflux.instituto.entity.dto.EstudianteDTO;
import com.webflux.instituto.repo.CursoRepo;
import com.webflux.instituto.repo.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepo estudianteRepo;
    @Autowired
    private CursoRepo cursoRepo;

    @Autowired
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    public EstudianteService(R2dbcEntityTemplate r2dbcEntityTemplate) {
        this.r2dbcEntityTemplate = r2dbcEntityTemplate;
    }

    public Mono<Estudiante> registrarEstudiante(EstudianteDTO estudianteDTO){
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre(estudianteDTO.getNombre());
        nuevoEstudiante.setEdad(estudianteDTO.getEdad());
        nuevoEstudiante.setCurso(estudianteDTO.getCurso());
        nuevoEstudiante.setDireccion(estudianteDTO.getDireccion());
        nuevoEstudiante.setCorreo(estudianteDTO.getCorreo());
        nuevoEstudiante.setTelefono(estudianteDTO.getTelefono());
        return estudianteRepo.save(nuevoEstudiante);
    }
    public Mono<Estudiante> actualizarEstudiante(Long estudiante_id, Estudiante estudiante){
        return estudianteRepo.findById(estudiante_id).map(
                (e) -> {
                    e.setNombre(estudiante.getNombre());
                    e.setEdad(estudiante.getEdad());
                    e.setCurso(estudiante.getCurso());
                    e.setDireccion(estudiante.getDireccion());
                    e.setCorreo(estudiante.getCorreo());
                    e.setTelefono(estudiante.getTelefono());
                    return e;
                }
        ).flatMap(e-> estudianteRepo.save(e));
    }
    public Mono<Void> eliminarEstudiante(Long estudiante_id){
        return estudianteRepo.deleteById(estudiante_id);
    }

    public Flux<Estudiante> obtenerEstudiantesXEdad(int edad){
        return estudianteRepo.findByEdad(edad);
    }
    public Mono<Void> asignarCurso(Long estudiante_id, Long curso_id) {
        return estudianteRepo.findById(estudiante_id)
                .flatMap(estudiante -> cursoRepo.findById(curso_id)
                        .flatMap(course -> {
                            estudiante.setCurso(curso_id);
                            return estudianteRepo.save(estudiante).then();
                        }));
    }
    public Flux<EstudianteCursoDTO> obtenerDetallesEstudianteCurso(Long estudianteId) {
        return estudianteRepo.obtenerEstudianteCurso(estudianteId);
    }
}
