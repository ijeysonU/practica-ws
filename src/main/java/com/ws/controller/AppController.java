package com.ws.controller;


import com.ws.business.iAlumnoBusiness;
import com.ws.model.dto.ErrorResponse;
import org.apache.http.HttpStatus;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
public class AppController {

    @Inject
    @Named("AlumnoBusiness")
    private iAlumnoBusiness alumnoBusiness;
    
    @GET
    @Path("/alumno/{idAlumno}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAlumnoID(@PathParam("idAlumno") Long idAlumno)
    {
        try{
            return Response.ok().entity(alumnoBusiness.findById(idAlumno)).build();
        }catch (Exception e){
            return Response.status(HttpStatus.SC_CONFLICT).entity(new ErrorResponse(e.getMessage())).build();
        }
    }

    @GET
    @RolesAllowed("admin")
    @Path("/alumno")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAlumno(){
        return Response.ok().entity(alumnoBusiness.findAll()).build();
    }
}