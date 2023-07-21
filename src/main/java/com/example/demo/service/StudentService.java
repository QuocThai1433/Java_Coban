package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.StudentMapper;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.interfaces.IStudentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class StudentService extends BaseService<StudentDTO, UUID> implements IStudentService {
    public final StudentMapper studentMapper;
    public  final StudentRepository studentRepository;



    protected StudentService(JpaRepository<StudentDTO, UUID> repository, StudentMapper mapper, StudentMapper studentMapper, StudentRepository studentRepository) {
        super(repository, mapper);
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }


//    public StudentDTO createdto ( StudentDTO dto)
//    {
//        Student student = this.studentMapper.toEntity(dto);
//                student = studentRepository.save(student);
//                return  this.studentMapper.toDTO(student);
//    }

}
