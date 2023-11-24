package com.example.demo.service.interfaces;

import com.example.demo.dto.teacher.CreateTeacherRequest;
import com.example.demo.dto.teacher.TeacherDTO;

public interface ITeacherService {
    TeacherDTO create(CreateTeacherRequest request);
    
    TeacherDTO findById(Long id);
}
