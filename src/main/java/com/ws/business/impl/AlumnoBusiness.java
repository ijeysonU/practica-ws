package com.ws.business.impl;

import com.ws.business.iAlumnoBusiness;
import com.ws.mapper.iAlumnoMapper;
import com.ws.model.dto.AlumnoDto;
import com.ws.proxy.iAlumnoProxy;
import com.ws.service.iAlumnoService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Named("AlumnoBusiness")
@ApplicationScoped
public class AlumnoBusiness implements iAlumnoBusiness {

    @Inject
    private iAlumnoService alumnoService;

    @Inject
    @RestClient
    private iAlumnoProxy alumnoProxy;

    @Inject
    private iAlumnoMapper mapper;

    @Override
    public List<AlumnoDto> findAll() {
        return alumnoProxy.getAll()
                .stream().map(mapper::toProxyDto)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDto findById(Long idAlumno) throws Exception {
        AlumnoDto alumnoDto = alumnoService.findById(idAlumno);
        log.info("alumno data bd =>" + alumnoDto);
        if (alumnoDto == null){
            AlumnoDto alumnoD = mapper.toProxyDto(alumnoProxy.getById(idAlumno));
            log.info("Alumno data proxy =>" + alumnoD);
            if (alumnoD == null){
                alumnoService.save(alumnoD);
                return alumnoD;
            }
            throw new Exception("No se encontro Post con el id => " + idAlumno);
        }
        return alumnoDto;
    }

    @Override
    public AlumnoDto save(AlumnoDto alumnoDto) {
        return null;
    }
}
