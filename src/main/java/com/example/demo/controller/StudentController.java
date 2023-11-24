package com.example.demo.controller;

import com.example.demo.controller.interfaces.IStudentController;
import com.example.demo.service.interfaces.IStudentService;
import com.example.demo.dto.student.CreateStudentRequest;
import com.example.demo.dto.student.StudentDTO;
import com.example.demo.dto.student.UpdateStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController implements IStudentController {

    public final IStudentService studentService;
    
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
    public ResponseEntity<List<StudentDTO>> filterStudent(String name , Pageable pageable) {
        return ResponseEntity.ok(this.studentService.filter(name,pageable));

    }

}
