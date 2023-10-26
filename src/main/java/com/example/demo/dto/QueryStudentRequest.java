package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryStudentRequest {
    private String fullName;
    private String age;
    private String address;
    private String score;
    private String[] sorts;
}
