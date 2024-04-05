package com.webflux.instituto.repo;

import com.webflux.instituto.entity.bd.Estudiante;
import com.webflux.instituto.entity.dto.CursoEstudiantesDTO;
import com.webflux.instituto.entity.dto.EstudianteCursoDTO;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EstudianteRepo extends ReactiveCrudRepository<Estudiante, Long> {
    @Query("SELECT * FROM estudiante WHERE edad = $1")
    Flux<Estudiante> findByEdad(int edad);
    @Query("SELECT e.estudiante_id, e.nombre as estudiante_nombre, e.edad as estudiante_edad, e.curso as estudiante_curso_id, " +
            "e.direccion as estudiante_direccion, e.correo as estudiante_correo, e.telefono as estudiante_telefono, " +
            "c.curso_id, c.nombre as curso_nombre, c.profesor as curso_profesor, c.descripcion as curso_descripcion " +
            "FROM estudiante e " +
            "INNER JOIN curso c ON e.curso = c.curso_id " +
            "WHERE e.estudiante_id = :estudianteId")
    Flux<EstudianteCursoDTO> obtenerEstudianteCurso(Long estudianteId);
}
