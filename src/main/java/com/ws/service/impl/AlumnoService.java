package com.ws.service.impl;

import com.ws.mapper.iAlumnoMapper;
import com.ws.model.dto.AlumnoDto;
import com.ws.model.entity.AlumnoEntity;
import com.ws.repository.AlumnoRepository;
import com.ws.service.iAlumnoService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class AlumnoService implements iAlumnoService {

    private final AlumnoRepository repository;
    private final iAlumnoMapper mapper;

    @Override
    public List<AlumnoDto> findAll() {

        return null;
    }

    @Override
    public AlumnoDto findById(Long idAlumno) {
        return mapper.toDto(repository.findById(idAlumno));
    }

    @Override
    @Transactional
    public AlumnoDto save(AlumnoDto alumnoDto) {
        repository.persist(mapper.toEntity(alumnoDto));
        return alumnoDto;
    }
}
