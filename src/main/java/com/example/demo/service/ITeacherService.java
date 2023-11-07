package com.example.demo.service;

import com.example.demo.service.dto.teacher.CreateTeacherRequest;
import com.example.demo.service.dto.teacher.TeacherDTO;

public interface ITeacherService {
    TeacherDTO create(CreateTeacherRequest request);
    
    TeacherDTO findById(Long id);
}
