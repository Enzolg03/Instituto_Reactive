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
public class Curso {
    @Id
    private Long curso_id;
    @Column
    private String nombre;
    @Column
    private String profesor;
    @Column
    private String descripcion;
}
