package com.example.demo.service.mapper;

import com.example.demo.entity.Classes;
import com.example.demo.entity.Students;
import com.example.demo.service.dto.classes.ClassesDTO;
import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.UpdateStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    
    public Students toEntityForCreate(CreateStudentRequest request, Set<Classes> classesSet) {
        return Students.builder()
            .name(request.getName())
            .age(request.getAge())
            .address(request.getAddress())
            .score(request.getScore())
            .dateOfBirth(request.getDateOfBirth())
            .classesSet(classesSet)
            .build();
    }
    
    
    public StudentDTO toDTO(Students entity) {
        return StudentDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .age(entity.getAge())
            .address(entity.getAddress())
            .dateOfBirth(entity.getDateOfBirth())
            .score(entity.getScore())
            .classesList(
                entity.getClassesSet().stream()
                    .map(item -> ClassesDTO.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .build())
                    .collect(Collectors.toSet())
            )
            .build();
    }
    
    public Students toEntityForUpdate(Students students, UpdateStudentRequest request, Set<Classes> classesList) {
        return students.toBuilder()
            .name(request.getName())
            .address(request.getAddress())
            .age(request.getAge())
            .score(request.getScore())
            .dateOfBirth(request.getDateOfBirth())
            .classesSet(classesList)
            .build();
    }
}
