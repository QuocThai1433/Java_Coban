package com.example.demo.service.impl;

import com.example.demo.service.dto.classes.ClassesDTO;
import com.example.demo.service.dto.classes.CreateClassesRequest;
import com.example.demo.service.mapper.ClassesMapper;
import com.example.demo.entity.Classes;
import com.example.demo.repository.ClassesRepository;
import com.example.demo.service.IClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassesService implements IClassesService {
    
    private final ClassesRepository classesRepository;
    
    private final ClassesMapper classesMapper;
    
    @Override
    public ClassesDTO create(CreateClassesRequest request) {
        Classes classes = this.classesMapper.toCreateEntity(request);
        classes = this.classesRepository.save(classes);
        return this.classesMapper.toDTO(classes);
    }
    
    @Override
    public ClassesDTO findById(Long classId) {
        return this.classesRepository.findById(classId)
            .map(this.classesMapper::toDTO)
            .orElseThrow(
                RuntimeException::new
            );
    }
}
