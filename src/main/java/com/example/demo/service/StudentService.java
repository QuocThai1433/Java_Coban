package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.service.interfaces.IStudentService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public class StudentService extends BaseService<Student, UUID> implements IStudentService {
    protected StudentService(JpaRepository<Student, UUID> repository) {
        super(repository);
    }
}
