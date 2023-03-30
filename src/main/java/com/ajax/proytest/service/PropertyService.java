package com.ajax.proytest.service;

import com.ajax.proytest.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto saveproperty(PropertyDto dto);

    List<PropertyDto> findAll();
    PropertyDto updateProperty(PropertyDto dto, Long id);


    PropertyDto updatePropertyPrecio(PropertyDto dto, Long id);

    PropertyDto updatePropertyDescripcion(PropertyDto dto, Long id);

    void deleteByid(Long id);
}
