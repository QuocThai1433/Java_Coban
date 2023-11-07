package com.example.demo.controller.impl;

import com.example.demo.controller.ITeacherController;
import com.example.demo.service.ITeacherService;
import com.example.demo.service.dto.teacher.CreateTeacherRequest;
import com.example.demo.service.dto.teacher.TeacherDTO;
import com.example.demo.service.impl.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherController implements ITeacherController {
    
    private final ITeacherService teacherService;
    
    @Override
    public ResponseEntity<TeacherDTO> findById(Long id) {
        return null;
    }
    
    @Override
    public ResponseEntity<TeacherDTO> create(CreateTeacherRequest request) {
        return ResponseEntity.ok(this.teacherService.create(request));
    }
}
