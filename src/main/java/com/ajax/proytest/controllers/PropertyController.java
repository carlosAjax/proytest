package com.ajax.proytest.controllers;

import com.ajax.proytest.dto.PropertyDto;
import com.ajax.proytest.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @Value("${pms.dummy}")
    private String dummy;

    @GetMapping("/")
    public String sayHello(){
        return "Hola";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto){
        propertyDto =propertyService.saveproperty(propertyDto);
        return new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> findAllProperties(){
        System.out.println(dummy);
        return new ResponseEntity<>(propertyService.findAll(), HttpStatus.OK);
    }

    @PostMapping("properties/{id}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto dto, @PathVariable Long id){

        dto = propertyService.updateProperty(dto, id);
        return new ResponseEntity<PropertyDto>(dto,HttpStatus.CREATED);
    }
    @PatchMapping("/properties/update-precio/{id}")
    public ResponseEntity<PropertyDto> updatePropertyPrecio(@RequestBody PropertyDto dto, @PathVariable Long id){
        dto = propertyService.updatePropertyPrecio(dto,id);
        return new ResponseEntity<PropertyDto>(dto,HttpStatus.OK);
    }

    @PatchMapping("/properties/update-descripcion/{id}")
    public ResponseEntity<PropertyDto> updatePropertyDescripcion(@RequestBody PropertyDto dto, @PathVariable Long id){
        dto = propertyService.updatePropertyDescripcion(dto,id);
        return new ResponseEntity<PropertyDto>(dto,HttpStatus.OK);
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id){
        propertyService.deleteByid(id);
        return new ResponseEntity<Void>((Void) null, HttpStatus.NO_CONTENT);


    }

}
