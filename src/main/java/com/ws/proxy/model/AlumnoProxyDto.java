package com.ws.proxy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoProxyDto {
    private Long id;
    private String nombre;
    private String apellido;
}
