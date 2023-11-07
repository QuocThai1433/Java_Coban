package com.example.demo.service.dto.student;

import com.example.demo.service.dto.classes.ClassesDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

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
    
    private Date dateMonth;
    
    private ClassesDTO classes;
}
