package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.mapper.IBaseMapper;
import com.example.demo.entity.Students;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.interfaces.IStudentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService extends BaseService<Students, UUID, StudentDTO> implements IStudentService {
    public final StudentRepository studentRepository;
    protected StudentService(JpaRepository<Students, UUID> repository, IBaseMapper<Students, StudentDTO, UUID> mapper, StudentRepository studentRepository) {
        super(repository, mapper);
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getListCount() {
        return studentRepository.studentList(scanner.nextInt()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
