package com.example.demo.controller;

import com.example.demo.controller.interfaces.IClassesController;
import com.example.demo.service.interfaces.IClassesService;
import com.example.demo.dto.classes.ClassesDTO;
import com.example.demo.dto.classes.CreateClassesRequest;
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
