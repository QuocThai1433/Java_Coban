package com.example.demo.service.interfaces;

import com.example.demo.dto.student.CreateStudentRequest;
import com.example.demo.dto.student.StudentDTO;
import com.example.demo.dto.student.UpdateStudentRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    StudentDTO create(CreateStudentRequest request);
    
    StudentDTO update(Long id, UpdateStudentRequest request);
    
    StudentDTO findById(Long id);

    List<StudentDTO> filter (String name, Pageable pePageable);
}
