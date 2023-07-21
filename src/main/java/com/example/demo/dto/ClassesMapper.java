package com.example.demo.dto;

import com.example.demo.entity.Classes;
import org.springframework.stereotype.Component;

@Component
public class ClassesMapper implements IBaseMapper<Classes, ClassesDTO> {
    @Override
    public Classes toEntity(ClassesDTO dto) {
        return Classes.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public ClassesDTO toDto(Classes entity) {
        return ClassesDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
