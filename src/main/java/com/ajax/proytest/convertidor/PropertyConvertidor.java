package com.ajax.proytest.convertidor;

import com.ajax.proytest.dto.PropertyDto;
import com.ajax.proytest.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConvertidor {

    public PropertyEntity convertirDtoEnEntity(PropertyDto dto){
        PropertyEntity pe = new PropertyEntity();
        pe.setDescripcion(dto.getDescripcion());
        pe.setEmail(dto.getEmail());
        pe.setDireccion(dto.getDireccion());
        pe.setPrecio(dto.getPrecio());
        pe.setTitulo(dto.getTitulo());
        pe.setNombre(dto.getNombre());
        return pe;
    }

    public PropertyDto convertirEntityEnDto(PropertyEntity entity){
        PropertyDto dto = new PropertyDto();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEmail(entity.getEmail());
        dto.setDireccion(entity.getDireccion());
        dto.setPrecio(entity.getPrecio());
        dto.setTitulo(entity.getTitulo());
        dto.setNombre(entity.getNombre());
        return dto;
    }
}
