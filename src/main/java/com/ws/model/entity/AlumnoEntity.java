package com.ws.model.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "alumno")
@Data
public class AlumnoEntity extends PanacheEntity {
    private Long id;
    private String nombre;
    private String apellido;

}
