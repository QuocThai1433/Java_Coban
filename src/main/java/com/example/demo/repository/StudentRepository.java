package com.example.demo.repository;

import com.example.demo.entity.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    
    @Query(
        "select s " +
        "from Students s " +
        "where (:searchTerm is null or concat(s.name, s.address) like concat('%', :searchTerm, '%')) " +
        "and (:age is null or s.age = :age)"
    )
    Page<Students> getPageByFilter(
        @Param("searchTerm") String searchTerm,
        @Param("age") Integer age,
        Pageable pageable
    );
}
