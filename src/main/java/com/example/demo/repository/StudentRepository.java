package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(
        nativeQuery = true,
        value = "select distinct s.* " +
            "from student s " +
            "         left join rel_student_classes rsc on s.id = rsc.student_id " +
            "         left join classes c on rsc.classes_id = c.id " +
            "         left join rel_teacher_classes rtc on c.id = rtc.class_id " +
            "         left join teacher t on rtc.teacher_id = t.id " +
            "where (:searchTerm is null or :searchTerm = '' or " +
            "       concat(coalesce(s.name, ''), coalesce(s.address, ''), coalesce(t.name, ''), coalesce(c.name, '')) like " +
            "       concat('%', :searchTerm, '%')) " +
            "  and (:age is null or s.age = :age)",
        countQuery = "select distinct count(s.*) " +
            "from student s " +
            "         left join rel_student_classes rsc on s.id = rsc.student_id " +
            "         left join classes c on rsc.classes_id = c.id " +
            "         left join rel_teacher_classes rtc on c.id = rtc.class_id " +
            "         left join teacher t on rtc.teacher_id = t.id " +
            "where (:searchTerm is null or :searchTerm = '' or " +
            "       concat(coalesce(s.name, ''), coalesce(s.address, ''), coalesce(t.name, ''), coalesce(c.name, '')) like " +
            "       concat('%', :searchTerm, '%')) " +
            "  and (:age is null or s.age = :age)"
    )
    Page<Student> query(
        @Param("searchTerm") String searchTerm,
        @Param("age") Integer age,
        Pageable pageable
    );

    @Transactional(readOnly = true)
    @Query(
        value = "select s.id, s.name " +
            "from Students s",
        nativeQuery = true
    )
    Stream<StudentRecord> getAll();

    interface StudentRecord {
        Long getId();

        String getName();
    }
}
