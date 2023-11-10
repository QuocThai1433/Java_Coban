package com.example.demo.service.mapper;

import com.example.demo.entity.Classes;
import com.example.demo.service.dto.classes.ClassesDTO;
import com.example.demo.service.dto.classes.CreateClassesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClassesMapper {
    private final TeacherMapper teacherMapper;
    
    public Classes toCreateEntity(CreateClassesRequest request) {
        return Classes.builder()
            .name(request.getName())
            .build();
    }
    
    public ClassesDTO toDTO(Classes entity) {
        return ClassesDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .teachers(
                MapperUtil.mapSet(
                    entity.getTeachers(),
                    this.teacherMapper::toDTO
                )
            )
            .build();
    }
}
