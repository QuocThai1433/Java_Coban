package com.example.demo.controller;

import com.example.demo.service.dto.teacher.CreateTeacherRequest;
import com.example.demo.service.dto.teacher.TeacherDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/teachers")
public interface ITeacherController {
    
    @GetMapping("{id}")
    ResponseEntity<TeacherDTO> findById(@PathVariable("id") Long id);
    
    @PostMapping
    ResponseEntity<TeacherDTO> create(@RequestBody CreateTeacherRequest request);
}
