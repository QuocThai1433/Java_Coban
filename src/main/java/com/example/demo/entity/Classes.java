package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "classes")
@Getter
@Setter
@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class Classes {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "class_name")
    private String className;

    @OneToMany (mappedBy = "classes")
    List<Student> students = new ArrayList<>();

}
