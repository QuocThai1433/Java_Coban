package com.example.demo.controller;

import com.example.demo.controller.interfaces.IStudentController;
import com.example.demo.entity.Student;
import com.example.demo.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public class StudentController extends BaseService<Student, UUID> implements IStudentController {
    protected StudentController(JpaRepository<Student, UUID> repository) {
        super(repository);
    }
}
