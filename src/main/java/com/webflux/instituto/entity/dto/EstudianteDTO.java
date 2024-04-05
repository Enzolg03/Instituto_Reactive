package com.webflux.instituto.entity.dto;

import lombok.Data;

@Data
public class EstudianteDTO {
    private Long estudiante_id;
    private String nombre;
    private int edad;
    private Long curso;
    private String direccion;
    private String correo;
    private String telefono;
}
