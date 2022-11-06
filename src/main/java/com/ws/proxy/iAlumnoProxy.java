package com.ws.proxy;

import com.ws.proxy.model.AlumnoProxyDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@RegisterRestClient(configKey = "quarkus-data")
public interface iAlumnoProxy {

    @GET
    @Path("alumno/{idAlumno}")
    AlumnoProxyDto getById(@PathParam("idAlumno") Long idAlumno);

    @GET
    @Path("alumno")
    List<AlumnoProxyDto> getAll();
}
