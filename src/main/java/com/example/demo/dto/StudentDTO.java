package com.example.demo.dto;

import com.example.demo.entity.Classes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class StudentDTO {
    private UUID id;

    private String name;

    private int age;

    private String address;

    private float score;

    @JsonIgnore
    private Classes classes;
}
