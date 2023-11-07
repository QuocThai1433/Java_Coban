package com.example.demo.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "students")
@Getter
@Setter
@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class Students {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private int age;
    
    private String address;
    
    private float score;
    
    private ZonedDateTime dateOfBirth;
    
    @Builder.Default
    @ManyToMany
    @JoinTable(
        name = "rel_student_classes",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "classes_id")
    )
    private Set<Classes> classesSet = new HashSet<>();
}
