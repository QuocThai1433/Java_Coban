package com.example.demo.service.mapper;

import com.example.demo.service.dto.classes.ClassesDTO;
import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.UpdateStudentRequest;
import com.example.demo.entity.Classes;
import com.example.demo.entity.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    
    public Students toEntityForCreate(CreateStudentRequest request, Classes classes) {
        return Students.builder()
            .name(request.getName())
            .age(request.getAge())
            .address(request.getAddress())
            .score(request.getScore())
            .classes(classes)
            .build();
    }
    
    
    public StudentDTO toDTO(Students entity) {
        return StudentDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .age(entity.getAge())
            .address(entity.getAddress())
            .score(entity.getScore())
            .classes(
                Objects.nonNull(entity.getClasses()) ?
                    ClassesDTO.builder()
                        .id(entity.getClasses().getId())
                        .name(entity.getClasses().getName())
                        .build()
                    : null
            )
            .build();
    }
    
    public Students toEntityForUpdate(Students students, UpdateStudentRequest request, Classes classes) {
        return students.toBuilder()
            .name(request.getName())
            .address(request.getAddress())
            .age(request.getAge())
            .score(request.getScore())
            .dateMonth(request.getDateMonth())
            .classes(classes)
            .build();
    }
}
