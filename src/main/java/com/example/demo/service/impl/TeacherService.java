package com.example.demo.service.impl;

import com.example.demo.entity.Teacher;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.ITeacherService;
import com.example.demo.service.dto.teacher.CreateTeacherRequest;
import com.example.demo.service.dto.teacher.TeacherDTO;
import com.example.demo.service.dto.teacher.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService implements ITeacherService {
    
    private final TeacherMapper teacherMapper;
    
    private final TeacherRepository teacherRepository;
    
    public TeacherDTO create(CreateTeacherRequest request) {
        Teacher teacher = this.teacherMapper.toEntity(request);
        teacher = this.teacherRepository.save(teacher);
        return this.teacherMapper.toDTO(teacher);
    }
    
    @Override
    public TeacherDTO findById(Long id) {
        return this.teacherRepository.findById(id)
            .map(this.teacherMapper::toDTO)
            .orElseThrow(
                () -> new BadRequestException("Teacher not found")
            );
    }
}
