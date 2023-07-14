package com.example.demo.controller;

import com.example.demo.controller.interfaces.IClassesController;
import com.example.demo.entity.Classes;
import com.example.demo.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public class ClassesContoller extends BaseService<Classes, UUID> implements IClassesController {
    protected ClassesContoller(JpaRepository<Classes, UUID> repository) {
        super(repository);
    }
}
