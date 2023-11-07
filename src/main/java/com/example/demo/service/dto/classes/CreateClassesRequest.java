package com.example.demo.service.dto.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreateClassesRequest {
    
    @NotBlank
    private String name;
}
