package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class ClassesDTO {
    private UUID id;
    private String name;
}
