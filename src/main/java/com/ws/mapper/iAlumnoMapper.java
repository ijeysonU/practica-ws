package com.ws.mapper;

import com.ws.model.dto.AlumnoDto;
import com.ws.model.entity.AlumnoEntity;
import com.ws.proxy.model.AlumnoProxyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface iAlumnoMapper {

    AlumnoDto toDto(AlumnoEntity alumnoEntity);

    @Mapping(target = "id", ignore = true)
    AlumnoDto toProxyDto(AlumnoProxyDto alumnoProxyDto);
    AlumnoProxyDto toDto(AlumnoDto alumnoDto);
    AlumnoEntity toEntity(AlumnoDto alumnoDto);


}
