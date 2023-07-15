package com.example.demo.service;

import com.example.demo.entity.Classes;
import com.example.demo.service.interfaces.IClassesService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ClassesService extends BaseService<Classes, UUID> implements IClassesService {
    protected ClassesService(JpaRepository<Classes, UUID> repository) {
        super(repository);
    }
}
