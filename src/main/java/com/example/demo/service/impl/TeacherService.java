package com.example.demo.service.impl;

import com.example.demo.entity.Classes;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.ClassesRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.ITeacherService;
import com.example.demo.service.dto.teacher.CreateTeacherRequest;
import com.example.demo.service.dto.teacher.TeacherDTO;
import com.example.demo.service.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherService implements ITeacherService {
    
    private final TeacherMapper teacherMapper;
    
    private final TeacherRepository teacherRepository;
    
    private final ClassesRepository classesRepository;
    
    public TeacherDTO create(CreateTeacherRequest request) {
        Set<Classes> classesSet = this.buildClassesList(request.getClassIds());
        
        Teacher teacher = this.teacherMapper.toEntityForCreate(request, classesSet);
        
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
    
    private Set<Classes> buildClassesList(Set<Long> classIds) {
        Set<Classes> classesSet = new HashSet<>();
        classIds.forEach(id ->
            this.classesRepository.findById(id)
                    .ifPresent(
                classesSet::add // item -> classest.add(item)
            )
        );
        return classesSet;
    }
}
