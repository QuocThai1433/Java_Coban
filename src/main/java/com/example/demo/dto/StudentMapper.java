package com.example.demo.dto;

import com.example.demo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class  StudentMapper {
    @Bean
    public Student toEntity(StudentDTO studentDTO)
    {
        return Student.builder()
                .id(studentDTO.getId())
                .name(studentDTO.getName())
                .age(studentDTO.getAge())
                .address(studentDTO.getAddress())
                .score(studentDTO.getScore())
                .build();
    }

    public  StudentDTO toDTO(Student studentEntity)
    {
        return StudentDTO.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .age(studentEntity.getAge())
                .address(studentEntity.getAddress())
                .score(studentEntity.getScore())
                .build();
    }
}
