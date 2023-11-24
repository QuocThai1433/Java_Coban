package com.example.demo.mapper;

import com.example.demo.dto.classes.ClassesDTO;
import com.example.demo.dto.classes.CreateClassesRequest;
import com.example.demo.entity.Classes;
import org.springframework.stereotype.Component;

@Component
public class ClassesMapper {
    
    public Classes toCreateEntity(CreateClassesRequest request) {
        return Classes.builder()
            .name(request.getName())
            .build();
    }
    
    
    public ClassesDTO toDTO(Classes entity) {
        return ClassesDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .build();
    }
}
