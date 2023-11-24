package com.example.demo.dto.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class StudentFilter {
    
    private String searchTerm;
    
    private Integer age;
    
}
