package com.example.demo.service.dto.classes;

import com.example.demo.service.dto.teacher.TeacherDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class ClassesDTO {
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    
    private String name;
    
    @Builder.Default
    private Set<TeacherDTO> teachers = new HashSet<>();
}
