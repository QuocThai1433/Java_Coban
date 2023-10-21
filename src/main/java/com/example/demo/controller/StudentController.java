package com.example.demo.controller;

import com.example.demo.controller.interfaces.IStudentController;
import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.interfaces.IBaseService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class StudentController extends BaseController<StudentDTO, UUID> implements IStudentController {
    public final StudentRepository repository;
    public final StudentMapper mapper;

    public StudentController(IBaseService<StudentDTO, UUID> iBaseService, StudentRepository repository, StudentMapper mapper) {
        super(iBaseService);
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("getListCountStudent")
    public ResponseEntity<List<StudentDTO>> getListCountStudent(@RequestParam Integer count) {

        return ResponseEntity.ok(repository.studentList(count)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("getPaging")
    public ResponseEntity<List<StudentDTO>> getPaging(@RequestParam Integer page, @RequestParam Integer size) {

        Integer offset = page * size;
        return ResponseEntity.ok(repository.studentPaging(size, offset)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("getFilter")
    public ResponseEntity<List<StudentDTO>> getFilter(@RequestParam(required = false) String findName, @RequestParam(required = false) Integer age) {
//        var a=repository.studentFilter(findName,age);
        return ResponseEntity.ok(repository.studentFilter(findName, age)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("sortStudent")
    public ResponseEntity<List<StudentDTO>> sortStudent(@RequestParam String name, String age, String score, String dateMonth) {
        return ResponseEntity.ok(repository.sortStudent(name, age, score, dateMonth)
                .stream().map(mapper::toDto).collect(Collectors.toList()));


    }
}
