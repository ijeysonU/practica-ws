package com.ws.business;

import com.ws.model.dto.AlumnoDto;

import java.util.List;

public interface iAlumnoBusiness {
    List<AlumnoDto> findAll();
    AlumnoDto findById(Long idAlumno) throws Exception;
    AlumnoDto save(AlumnoDto alumnoDto);

}
