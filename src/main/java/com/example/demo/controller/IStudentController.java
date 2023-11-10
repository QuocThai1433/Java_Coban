package com.example.demo.controller;

import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.StudentFilter;
import com.example.demo.service.dto.student.UpdateStudentRequest;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/students")
public interface IStudentController {
    @PostMapping
    ResponseEntity<StudentDTO> create(@RequestBody CreateStudentRequest request);
    
    @GetMapping("{id}")
    ResponseEntity<StudentDTO> findById(@PathVariable("id") Long id);
    
    @GetMapping
    ResponseEntity<List<StudentDTO>> getAll();
    
    @GetMapping("query")
    ResponseEntity<List<StudentDTO>> query(@ParameterObject StudentFilter filter, @ParameterObject Pageable pageable);
    
    @PutMapping("{id}")
    ResponseEntity<StudentDTO> update(@PathVariable("id") Long id, @RequestBody UpdateStudentRequest request);
}
