package com.example.demo.service.interfaces;

import com.example.demo.dto.classes.ClassesDTO;
import com.example.demo.dto.classes.CreateClassesRequest;

public interface IClassesService {
    ClassesDTO create(CreateClassesRequest request);
    
    ClassesDTO findById(Long classId);
}
