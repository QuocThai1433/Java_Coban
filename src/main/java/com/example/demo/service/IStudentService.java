package com.example.demo.service;

import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.StudentFilter;
import com.example.demo.service.dto.student.UpdateStudentRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    StudentDTO create(CreateStudentRequest request);
    
    StudentDTO update(Long id, UpdateStudentRequest request);
    
    StudentDTO findById(Long id);
    
    List<StudentDTO> getAll();
    
    List<StudentDTO> query(StudentFilter filter, Pageable pageable);
}
