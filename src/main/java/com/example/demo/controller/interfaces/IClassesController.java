package com.example.demo.controller.interfaces;

import com.example.demo.dto.classes.ClassesDTO;
import com.example.demo.dto.classes.CreateClassesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/classes")
public interface IClassesController {
    
    @GetMapping("{id}")
    ResponseEntity<ClassesDTO> findById(@PathVariable("id") Long id);
    
    @PostMapping
    ResponseEntity<ClassesDTO> create(@RequestBody CreateClassesRequest request);
   
}
