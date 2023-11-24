package com.example.demo.controller.interfaces;

import com.example.demo.dto.student.CreateStudentRequest;
import com.example.demo.dto.student.StudentDTO;
import com.example.demo.dto.student.UpdateStudentRequest;
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
    
    @PutMapping("{id}")
    ResponseEntity<StudentDTO> update(@PathVariable("id") Long id, @RequestBody UpdateStudentRequest request);

    @GetMapping("filter")
    ResponseEntity<List<StudentDTO>> filterStudent (@RequestParam String name, @ParameterObject Pageable pageable);

}
