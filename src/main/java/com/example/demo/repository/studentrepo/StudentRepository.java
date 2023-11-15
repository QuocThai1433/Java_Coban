package com.example.demo.repository.studentrepo;

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
                    "where (:searchTerm is null or concat(s.nameStudent, s.address) like concat('%', :searchTerm, '%')) " +
                    "and (:age is null or s.age = :age)"
    )
    Page<Students> getPageByFilter(
            @Param("searchTerm") String searchTerm,
            @Param("age") Integer age,
            Pageable pageable
    );

    @Query(value = "SELECT st.*,tc.class_id,t.name_teacher " +
            "FROM students st " +
            "left join rel_student_classes sc  " +
            "on st.id = sc.student_id   " +
            "left join classes c  " +
            "on sc.classes_id = c.id  " +
            "left join rel_teacher_classes tc  " +
            "on sc.classes_id = tc.class_id  " +
            "left join teacher t  " +
            "on tc.teacher_id = t.id " +
            "where if(:name is null, true, name_student like concat('%', :name, '%')) " ,
            nativeQuery = true,
            countQuery = "select count(*)" +
                    "FROM students st " +
                    "left join rel_student_classes sc  " +
                    "on st.id = sc.student_id   " +
                    "left join classes c  " +
                    "on sc.classes_id = c.id  " +
                    "left join rel_teacher_classes tc  " +
                    "on sc.classes_id = tc.class_id  " +
                    "left join teacher t  " +
                    "on tc.teacher_id = t.id " +
                    "where if(:name is null, true, name_student like concat('%', :name, '%')) ")
    Page<Students> studentFilter(@Param("name") String name, Pageable pageable);

}
