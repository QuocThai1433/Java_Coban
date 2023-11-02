package com.example.demo.service;

import com.example.demo.dto.teacher.CreateTeacherRequest;
import com.example.demo.dto.teacher.TeacherDTO;
import com.example.demo.dto.teacher.TeacherMapper;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherMapper teacherMapper;
    private final TeacherRepository teacherRepository;
    
    public TeacherService(TeacherMapper teacherMapper,
                          TeacherRepository teacherRepository) {
        this.teacherMapper = teacherMapper;
        this.teacherRepository = teacherRepository;
    }
    
    public TeacherDTO create(CreateTeacherRequest request) {
        Teacher teacher = this.teacherMapper.toEntity(request);
        teacher = this.teacherRepository.save(teacher);
        return this.teacherMapper.toDTO(teacher);
    }
}
