package com.example.demo.repository;

import com.example.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Students, UUID> {
    @Query(value = "SELECT * FROM students ORDER BY id ASC limit :count",
    nativeQuery = true)
    List<Students> studentList (@Param("count") Integer count);

    @Query(value = "SELECT * FROM students limit :size offset :offset",
    nativeQuery = true)
    List<Students> studentPaging (@Param("size") Integer size, @Param("offset") Integer offset);

    @Query(value = "SELECT * FROM students WHERE name LIKE CONCAT('%', :findName, '%') and age =:age ",
            nativeQuery = true)
    List<Students> studentFilter (@Param("findName") String name, @Param("age") Integer age);



}
