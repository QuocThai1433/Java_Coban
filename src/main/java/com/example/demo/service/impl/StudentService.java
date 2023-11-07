package com.example.demo.service.impl;

import com.example.demo.service.mapper.StudentMapper;
import com.example.demo.service.dto.student.CreateStudentRequest;
import com.example.demo.service.dto.student.StudentDTO;
import com.example.demo.service.dto.student.UpdateStudentRequest;
import com.example.demo.entity.Classes;
import com.example.demo.entity.Students;
import com.example.demo.repository.ClassesRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    
    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;
    private final StudentMapper studentMapper;
    
    @Override
    public StudentDTO create(CreateStudentRequest request) {
        Classes classes = Objects.nonNull(request.getClassId()) ?
            this.classesRepository.findById(request.getClassId()).orElse(null) : null;
        
        Students students = this.studentMapper.toEntityForCreate(request, classes);
        
        students = this.studentRepository.save(students);
        
        return this.studentMapper.toDTO(students);
    }
    
    @Override
    public StudentDTO update(Long id, UpdateStudentRequest request) {
        Students students = this.studentRepository.findById(id).orElseThrow(
            RuntimeException::new
        );
        
        Classes classes = Objects.nonNull(request.getClassId()) ?
            this.classesRepository.findById(request.getClassId()).orElse(null) : null;
        
        students = this.studentMapper.toEntityForUpdate(students, request, classes);
        
        students = this.studentRepository.save(students);
        
        return this.studentMapper.toDTO(students);
    }
    
    @Override
    public StudentDTO findById(Long id) {
        return this.studentRepository.findById(id)
            .map(this.studentMapper::toDTO)
            .orElseThrow(
                RuntimeException::new
            );
    }
}
