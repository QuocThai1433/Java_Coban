package com.example.demo.controller.impl;

import com.example.demo.controller.IClassesController;
import com.example.demo.service.IClassesService;
import com.example.demo.service.dto.classes.ClassesDTO;
import com.example.demo.service.dto.classes.CreateClassesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClassesController implements IClassesController {
    
    private final IClassesService classesService;
    
    @Override
    public ResponseEntity<ClassesDTO> findById(Long id) {
        return ResponseEntity.ok(this.classesService.findById(id));
    }
    
    @Override
    public ResponseEntity<ClassesDTO> create(CreateClassesRequest request) {
        return ResponseEntity.ok(this.classesService.create(request));
    }
}
