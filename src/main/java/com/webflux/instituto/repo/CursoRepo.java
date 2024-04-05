package com.webflux.instituto.repo;

import com.webflux.instituto.entity.bd.Curso;
import com.webflux.instituto.entity.dto.CursoEstudiantesDTO;
import com.webflux.instituto.entity.dto.EstudianteCursoDTO;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CursoRepo extends ReactiveCrudRepository<Curso, Long> {
    @Query("SELECT c.curso_id, c.nombre AS curso_nombre, c.profesor AS curso_profesor, " +
            "c.descripcion AS curso_descripcion, e.estudiante_id, e.nombre AS estudiante_nombre, " +
            "e.edad AS estudiante_edad, e.curso AS estudiante_curso_id, e.direccion AS estudiante_direccion, e.correo AS " +
            "estudiante_correo, e.telefono AS estudiante_telefono FROM curso c LEFT JOIN estudiante e " +
            "ON c.curso_id = e.curso")
    Flux<CursoEstudiantesDTO> obtenerCursosEstudiantes();

    @Query("SELECT c.curso_id, c.nombre AS curso_nombre, c.profesor AS curso_profesor, " +
            "c.descripcion AS curso_descripcion, e.estudiante_id, e.nombre AS estudiante_nombre, " +
            "e.edad AS estudiante_edad, e.curso AS estudiante_curso_id, e.direccion AS estudiante_direccion, e.correo AS " +
            "estudiante_correo, e.telefono AS estudiante_telefono FROM curso c LEFT JOIN estudiante e " +
            "ON c.curso_id = e.curso WHERE c.curso_id = :cursoId")
    Mono<CursoEstudiantesDTO> obtenerCursoEstudiantesPorId(Long cursoId);
}
