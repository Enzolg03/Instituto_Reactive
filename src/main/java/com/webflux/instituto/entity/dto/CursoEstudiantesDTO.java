package com.webflux.instituto.entity.dto;

import lombok.Data;

@Data
public class CursoEstudiantesDTO {
    private Long cursoId;
    private String cursoNombre;
    private String cursoProfesor;
    private String cursoDescripcion;

    private Long estudianteId;
    private String estudianteNombre;
    private int estudianteEdad;
    private Long estudianteCursoId;
    private String estudianteDireccion;
    private String estudianteCorreo;
    private String estudianteTelefono;
}
