package com.example.demo.controller.impl;

import com.example.demo.controller.IStudentController;
import com.example.demo.service.IStudentService;
import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.UpdateStudentRequest;
import com.example.demo.service.impl.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController implements IStudentController {
    
    public final IStudentService studentService;
    public final StudentService service;
    
    @Override
    public ResponseEntity<StudentDTO> create(CreateStudentRequest request) {
        return ResponseEntity.ok(this.studentService.create(request));
    }
    
    @Override
    public ResponseEntity<StudentDTO> findById(Long id) {
        return ResponseEntity.ok(this.studentService.findById(id));
    }
    
    @Override
    public ResponseEntity<StudentDTO> update(Long id, UpdateStudentRequest request) {
        return ResponseEntity.ok(this.studentService.update(id, request));
    }

    @Override
    public ResponseEntity<List<StudentDTO>> filterStudent(String fullName, Pageable pageable) {
        return ResponseEntity.ok(this.service.filter(fullName,pageable));
    }


}
