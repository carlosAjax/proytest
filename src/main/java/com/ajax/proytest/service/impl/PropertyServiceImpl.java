package com.ajax.proytest.service.impl;

import com.ajax.proytest.convertidor.PropertyConvertidor;
import com.ajax.proytest.dto.PropertyDto;
import com.ajax.proytest.entity.PropertyEntity;
import com.ajax.proytest.repository.PropetyRepsitory;
import com.ajax.proytest.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
@Autowired
private PropetyRepsitory propetyRepsitory;
@Autowired
private PropertyConvertidor convertidor;

    @Override
    public PropertyDto saveproperty(PropertyDto dto) {
        PropertyEntity pe = convertidor.convertirDtoEnEntity(dto);
        propetyRepsitory.save(pe);
        dto = convertidor.convertirEntityEnDto(pe);

        return dto;
    }

    @Override
    public List<PropertyDto> findAll() {
        List<PropertyDto> dtos = new ArrayList<>();
        List<PropertyEntity> entities;
        entities = (List<PropertyEntity>) propetyRepsitory.findAll();
       for(PropertyEntity entity: entities){
           dtos.add(convertidor.convertirEntityEnDto(entity));
        }
        return dtos;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto dto,Long id) {
        Optional<PropertyEntity> byId = propetyRepsitory.findById(id);
        PropertyDto dto1 = null;
        if(byId.isPresent()){
            PropertyEntity propertyBd = byId.get();
            propertyBd.setNombre(dto.getNombre());
            propertyBd.setTitulo(dto.getTitulo());
            propertyBd.setEmail(dto.getEmail());
            propertyBd.setPrecio(dto.getPrecio());
            propertyBd.setDireccion(dto.getDireccion());
            propertyBd.setDescripcion(dto.getDescripcion());
            dto1 = convertidor.convertirEntityEnDto(propertyBd);
            propetyRepsitory.save(propertyBd);
        }
        return dto1;

    }

    @Override
    public PropertyDto updatePropertyPrecio(PropertyDto dto, Long id) {
        Optional<PropertyEntity> byId = propetyRepsitory.findById(id);
        PropertyDto dto1 = null;
        if(byId.isPresent()){
            PropertyEntity propertyBd = byId.get();
            propertyBd.setPrecio(dto.getPrecio());
            dto1 = convertidor.convertirEntityEnDto(propertyBd);
            propetyRepsitory.save(propertyBd);
        }
        return dto1;
    }

    @Override
    public PropertyDto updatePropertyDescripcion(PropertyDto dto, Long id) {
        Optional<PropertyEntity> byId = propetyRepsitory.findById(id);
        PropertyDto dto1 = null;
        if(byId.isPresent()){
            PropertyEntity propertyBd = byId.get();
            propertyBd.setDescripcion(dto.getDescripcion());
            dto1 = convertidor.convertirEntityEnDto(propertyBd);
            propetyRepsitory.save(propertyBd);
        }
        return dto1;
    }

    @Override
    public void deleteByid(Long id) {
        propetyRepsitory.deleteById(id);
    }

}
