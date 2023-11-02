package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.mapper.IBaseMapper;
import com.example.demo.entity.Students;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.repository.StudentRepositoryIpl;
import com.example.demo.service.interfaces.IStudentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService extends BaseService<Students, Long, StudentDTO> implements IStudentService {
    public final IStudentRepository studentRepository;
    public final StudentRepositoryIpl studentRepositoryIpl;

    public StudentService(JpaRepository<Students, Long> repository, IBaseMapper<Students, StudentDTO, Long> mapper, IStudentRepository studentRepository, StudentRepositoryIpl studentRepositoryIpl) {
        super(repository, mapper);
        this.studentRepository = studentRepository;
        this.studentRepositoryIpl = studentRepositoryIpl;
    }


    public ResponseEntity<List<StudentDTO>> getListCountStudent(@RequestParam Integer count) {

        return ResponseEntity.ok(studentRepository.studentList(count)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
    }


    public ResponseEntity<List<StudentDTO>> getPaging(@RequestParam Integer page, @RequestParam Integer size) {

        Integer offset = page * size;
        return ResponseEntity.ok(studentRepository.studentPaging(size, offset)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<List<StudentDTO>> getFilter(@RequestParam(required = false) String findName, @RequestParam(required = false) Integer age) {
//        var a=repository.studentFilter(findName,age);
        return ResponseEntity.ok(studentRepository.studentFilter(findName, age)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("sortStudent")
    public ResponseEntity<List<StudentDTO>> sortStudent(@RequestParam String name){
        return ResponseEntity.ok(studentRepositoryIpl.getByFilter(name)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));


    }
}
