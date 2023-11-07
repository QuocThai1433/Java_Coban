package com.example.demo.service.dto.teacher;

import com.example.demo.service.dto.classes.ClassesDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class TeacherDTO {
    private Long id;
    
    private String name;
    
    private List<ClassesDTO> classesList;
}
