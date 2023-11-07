package com.example.demo.service.dto.teacher;

import com.example.demo.service.dto.classes.ClassesDTO;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.ClassesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeacherMapper {
    
    private final ClassesRepository classesRepository;
    
    public TeacherDTO toDTO(Teacher teacher) {
        return TeacherDTO.builder()
            .name(teacher.getName())
            .classesList(
                teacher.getClassesList()
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
    public Teacher toEntity(CreateTeacherRequest request) {
        return Teacher.builder()
            .name(request.getName())
            .classesList(
                request.getClassIds()
                    .stream()
                    .map(id -> this.classesRepository.findById(id).orElse(null))
                    .toList()
            )
            .build();
    }
}
