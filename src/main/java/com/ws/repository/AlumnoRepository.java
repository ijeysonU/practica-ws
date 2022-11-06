package com.ws.repository;

import com.ws.model.entity.AlumnoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlumnoRepository implements PanacheRepositoryBase<AlumnoEntity, Long> {

}
