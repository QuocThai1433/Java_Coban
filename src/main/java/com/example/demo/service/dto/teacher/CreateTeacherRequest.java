package com.example.demo.service.dto.teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreateTeacherRequest {
    
    private String name;
    
    private Set<Long> classIds;
}
