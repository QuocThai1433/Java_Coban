package com.example.demo.controller;

import com.example.demo.controller.interfaces.IClassesController;
import com.example.demo.entity.Classes;
import com.example.demo.service.BaseService;
import com.example.demo.service.interfaces.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class ClassesContoller extends BaseController<Classes, UUID> implements IClassesController {
    public ClassesContoller(IBaseService<Classes, UUID> idIBaseService) {
        super(idIBaseService);
    }
}
