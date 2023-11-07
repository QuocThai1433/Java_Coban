package com.example.demo.service.dto.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreateStudentRequest {
    
    private String name;
    
    private int age;
    
    private String address;
    
    private float score;
    
    private Date dateMonth;
    
    private Long classId;
}
