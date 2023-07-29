package com.example.demo.dto.mapper;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentMapper implements IBaseMapper<Student, StudentDTO, UUID> {

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
    public Student toEntity(StudentDTO dto, UUID id) {
        return Student.builder()
                .id(id)
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
