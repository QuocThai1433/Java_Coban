package com.example.demo.dto.student;

import com.example.demo.dto.classes.ClassesDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class StudentDTO {
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    
    private String name;
    
    private int age;
    
    private String address;
    
    private float score;
    
    private ZonedDateTime dateOfBirth;
    
    private Set<ClassesDTO> classesList;
}
