package com.example.demo.controller;

import com.example.demo.controller.interfaces.ITeacherController;
import com.example.demo.service.interfaces.ITeacherService;
import com.example.demo.dto.teacher.CreateTeacherRequest;
import com.example.demo.dto.teacher.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherController implements ITeacherController {
    
    private final ITeacherService teacherService;
    
    @Override
    public ResponseEntity<TeacherDTO> findById(Long id) {
        return ResponseEntity.ok(this.teacherService.findById(id));
    }
    
    @Override
    public ResponseEntity<TeacherDTO> create(CreateTeacherRequest request) {
        return ResponseEntity.ok(this.teacherService.create(request));
    }
}
