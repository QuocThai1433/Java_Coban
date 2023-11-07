package com.example.demo.controller;

import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.UpdateStudentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/students")
public interface IStudentController {
    @PostMapping
    ResponseEntity<StudentDTO> create(@RequestBody CreateStudentRequest request);
    
    @GetMapping("{id}")
    ResponseEntity<StudentDTO> findById(@PathVariable("id") Long id);
    
    @PutMapping("{id}")
    ResponseEntity<StudentDTO> update(@PathVariable("id") Long id, @RequestBody UpdateStudentRequest request);
}
