package com.ajax.proytest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDto {

    private Long id;
    private String titulo;
    private String descripcion;
    private String nombre;
    private String email;
    private Double precio;

    private String direccion;


}
