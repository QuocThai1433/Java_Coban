package com.example.demo.service;

import com.example.demo.entity.Classes;
import com.example.demo.entity.Students;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.ClassesRepository;
import com.example.demo.repository.studentrepo.StudentRepository;
import com.example.demo.service.interfaces.IStudentService;
import com.example.demo.dto.student.CreateStudentRequest;
import com.example.demo.dto.student.StudentDTO;
import com.example.demo.dto.student.UpdateStudentRequest;
import com.example.demo.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;
    private final StudentMapper studentMapper;


    @Override
    public StudentDTO create(CreateStudentRequest request) {
        Set<Classes> classes = this.buildClassesList(request.getClassIds());

        Students students = this.studentMapper.toEntityForCreate(request, classes);

        students = this.studentRepository.save(students);

        return this.studentMapper.toDTO(students);
    }

    @Override
    public StudentDTO update(Long id, UpdateStudentRequest request) {
        Students students = this.studentRepository.findById(id).orElseThrow(
                RuntimeException::new
        );

        Set<Classes> classesSet = this.buildClassesList(request.getClassIds());

        students = this.studentMapper.toEntityForUpdate(students, request, classesSet);

        students = this.studentRepository.save(students);

        return this.studentMapper.toDTO(students);
    }

    @Override
    public StudentDTO findById(Long id) {
        return this.studentRepository.findById(id)
                .map(this.studentMapper::toDTO)
                .orElseThrow(
                        () -> new BadRequestException("Student not found")
                );
    }

    @Override
    public List<StudentDTO> filter(String name, Pageable pePageable) {
        return this.studentRepository.studentFilter(name, pePageable)
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Set<Classes> buildClassesList(Set<Long> classIds) {
        Set<Classes> classesSet = new HashSet<>();
        classIds.forEach(id ->
                this.classesRepository.findById(id)
                        .ifPresent(
                                classesSet::add // item -> classesSet.add(item)
                        )
        );
        return classesSet;
    }


}

