package com.example.demo.service.mapper;

import com.example.demo.entity.Classes;
import com.example.demo.entity.Teacher;
import com.example.demo.service.dto.classes.ClassesDTO;
import com.example.demo.service.dto.teacher.CreateTeacherRequest;
import com.example.demo.service.dto.teacher.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeacherMapper {
    
    public TeacherDTO toDTO(Teacher teacher) {
        return TeacherDTO.builder()
            .id(teacher.getId())
            .name(teacher.getName())
            .classesList(
                teacher.getClassesSet()
                    .stream()
                    .map(item -> ClassesDTO.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .build())
                    .collect(Collectors.toList())
            )
            .build();
    }
    
    /**
     * @param request CreateTeacherRequest
     * @return Teacher
     */
    public Teacher toEntityForCreate(CreateTeacherRequest request, Set<Classes> classesSet) {
        return Teacher.builder()
            .name(request.getName())
            .classesSet(classesSet)
            .build();
    }
}
