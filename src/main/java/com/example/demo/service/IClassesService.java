package com.example.demo.service;

import com.example.demo.service.dto.classes.ClassesDTO;
import com.example.demo.service.dto.classes.CreateClassesRequest;

public interface IClassesService {
    ClassesDTO create(CreateClassesRequest request);
    
    ClassesDTO findById(Long classId);
}
