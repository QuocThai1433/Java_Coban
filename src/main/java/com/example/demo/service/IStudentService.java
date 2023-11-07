package com.example.demo.service;

import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.UpdateStudentRequest;

public interface IStudentService {
    StudentDTO create(CreateStudentRequest request);
    
    StudentDTO update(Long id, UpdateStudentRequest request);
    
    StudentDTO findById(Long id);
}
