package com.example.demo.controller;

import com.example.demo.dto.teacher.CreateTeacherRequest;
import com.example.demo.dto.teacher.TeacherDTO;
import com.example.demo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @PostMapping
    public ResponseEntity<TeacherDTO> create(@RequestBody CreateTeacherRequest request) {
        return ResponseEntity.ok(this.teacherService.create(request));
    }
}
