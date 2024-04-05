package com.webflux.instituto.entity.bd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estudiante {
    @Id
    private Long estudiante_id;
    @Column
    private String nombre;
    @Column
    private int edad;
    @Column("curso")
    private Long curso;
    @Column
    private String direccion;
    @Column
    private String correo;
    @Column
    private String telefono;
}
