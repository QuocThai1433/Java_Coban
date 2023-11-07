package com.example.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "classes")
@Getter
@Setter
@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class Classes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "classes")
    @Builder.Default
    private List<Students> students = new ArrayList<>();
    
    @Builder.Default
    @ManyToMany(mappedBy = "classesList")
    private List<Teacher> teachers = new ArrayList<>();
    
}
