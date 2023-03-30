package com.ajax.proytest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITULO", nullable = false)
    private String titulo;
    private String descripcion;
    private String nombre;
    @Column(name = "PROPERTY_email", nullable = false)
    private String email;
    private Double precio;

    private String direccion;
}
