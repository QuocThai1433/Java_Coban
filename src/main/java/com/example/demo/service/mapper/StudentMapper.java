package com.example.demo.service.mapper;

import com.example.demo.entity.Classes;
import com.example.demo.entity.Student;
import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.UpdateStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    
    private final ClassesMapper classesMapper;
    
    public Student toEntityForCreate(CreateStudentRequest request, Set<Classes> classesSet) {
        return Student.builder()
            .name(request.getName())
            .age(request.getAge())
            .address(request.getAddress())
            .score(request.getScore())
            .dateOfBirth(request.getDateOfBirth())
            .classesSet(classesSet)
            .build();
    }
    
    
    public StudentDTO toDTO(Student entity) {
        return StudentDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .age(entity.getAge())
            .address(entity.getAddress())
            .dateOfBirth(entity.getDateOfBirth())
            .score(entity.getScore())
            .classesList(
                MapperUtil.mapSet(
                    entity.getClassesSet(),
                    this.classesMapper::toDTO
                )
            )
            .build();
    }
    
    public Student toEntityForUpdate(Student student, UpdateStudentRequest request, Set<Classes> classesList) {
        return student.toBuilder()
            .name(request.getName())
            .address(request.getAddress())
            .age(request.getAge())
            .score(request.getScore())
            .dateOfBirth(request.getDateOfBirth())
            .classesSet(classesList)
            .build();
    }
}
