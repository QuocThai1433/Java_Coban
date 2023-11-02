package com.example.demo.dto.mapper;

import com.example.demo.dto.ClassesDTO;
import com.example.demo.entity.Classes;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClassesMapper implements IBaseMapper<Classes, ClassesDTO, Long> {
    @Override
    public Classes toEntity(ClassesDTO dto) {
        return Classes.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public Classes toEntity(ClassesDTO dto, Long id) {
        return Classes.builder()
                .id(id)
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
