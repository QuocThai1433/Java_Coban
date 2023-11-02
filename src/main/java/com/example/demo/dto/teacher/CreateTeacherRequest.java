package com.example.demo.dto.teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreateTeacherRequest {
    
    private String name;
    
    private List<Long> classIds;
}
