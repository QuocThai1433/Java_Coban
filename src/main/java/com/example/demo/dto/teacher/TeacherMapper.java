package com.example.demo.dto.teacher;

import com.example.demo.dto.mapper.ClassesMapper;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.ClassesRepository;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    private final ClassesMapper classesMapper;
    private final ClassesRepository classesRepository;
    
    public TeacherMapper(ClassesMapper classesMapper,
                         ClassesRepository classesRepository) {
        this.classesMapper = classesMapper;
        this.classesRepository = classesRepository;
    }
    
    public TeacherDTO toDTO(Teacher teacher) {
        return TeacherDTO.builder()
            .name(teacher.getName())
            .classesList(
                teacher.getClassesList()
                    .stream()
                    .map(this.classesMapper::toDto)
                    .toList()
            )
            .build();
    }
    
    /**
     * 
     * @param request CreateTeacherRequest
     * @return Teacher
     */
    public Teacher toEntity(CreateTeacherRequest request) {
        return Teacher.builder()
            .name(request.getName())
            .classesList(
                request.getClassIds()
                    .stream()
                    .map(id -> this.classesRepository.findById(id).orElse(null))
                    .toList()
            )
            .build();
    }
}
