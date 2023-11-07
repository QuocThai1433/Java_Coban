package com.example.demo.service.dto.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UpdateStudentRequest {
    
    private String name;
    
    private int age;
    
    private String address;
    
    private float score;
    
    private ZonedDateTime dateOfBirth;
    
    private Set<Long> classIds;
}
