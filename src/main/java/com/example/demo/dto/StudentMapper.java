package com.example.demo.dto;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements IBaseMapper<Student, StudentDTO> {

    @Override
    public Student toEntity(StudentDTO dto) {
        return Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .address(dto.getAddress())
                .score(dto.getScore())
                .build();
    }

    @Override
    public StudentDTO toDto(Student entity) {
        return StudentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .address(entity.getAddress())
                .score(entity.getScore())
                .build();
    }
}
