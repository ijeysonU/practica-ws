package com.ws.service;

import com.ws.model.dto.AlumnoDto;
import com.ws.model.entity.AlumnoEntity;

import java.util.List;

public interface iAlumnoService {
    List<AlumnoDto> findAll();
    AlumnoDto findById(Long idAlumno);
    AlumnoDto save(AlumnoDto alumnoEntity);
}
