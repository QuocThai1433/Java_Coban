package com.example.demo.controller;

import com.example.demo.controller.interfaces.IStudentController;
import com.example.demo.entity.Student;
import com.example.demo.service.BaseService;
import com.example.demo.service.interfaces.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class StudentController extends BaseController<Student, UUID> implements IStudentController {

    public StudentController(IBaseService<Student, UUID> idIBaseService) {
        super(idIBaseService);
    }
}
