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
    @Query(value = "SELECT * FROM student ORDER BY id ASC size =:count",
    nativeQuery = true)
    List<Students> studentList (@Param("count") Integer count);
}
