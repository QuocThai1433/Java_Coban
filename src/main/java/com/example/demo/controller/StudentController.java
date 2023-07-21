package com.example.demo.controller;

import com.example.demo.controller.interfaces.IStudentController;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.interfaces.IBaseService;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StudentController extends BaseController<StudentDTO, UUID> implements IStudentController {
    public StudentController(IBaseService<StudentDTO, UUID> iBaseService) {
        super(iBaseService);
    }
}
