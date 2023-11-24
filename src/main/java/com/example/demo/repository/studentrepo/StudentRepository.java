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


//    @Query(
//            "select st " +
//                    "from Students st " +
//                    "where (:searchTerm is null or concat(st.name, st.address) like concat('%', :searchTerm, '%')) " +
//                    "and (:age is null or s.age = :age)"
//    )
//    Page<Students> getPageByFilter(
//            @Param("searchTerm") String searchTerm,
//            @Param("age") Integer age,
//            Pageable pageable
//    );

    @Query(value = "SELECT st.*,t.name, count(sc.classes_id) as countId " +
            "FROM students st " +
            "left join rel_student_classes sc  " +
            "on st.id = sc.student_id   " +
            "left join classes c  " +
            "on sc.classes_id = c.id  " +
            "left join rel_teacher_classes tc  " +
            "on sc.classes_id = tc.class_id  " +
            "left join teacher t  " +
            "on tc.teacher_id = t.id " +
            "where if(:name is null, true , concat(st.name,c.name,coalesce(t.name,'')) like concat('%',  :name , '%'))" +
            "group by st.*,t.name " +
            "having count(sc.classes_id)",
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
                    "where if(:name is null, true,  concat(st.name , c.name , coalesce(t.name,'')) like concat('%', :name , '%') " +
                    "group by st.*,t.name " +
                    "having count(sc.classes_id) ")
    Page<Students> studentFilter(@Param("name") String name, Pageable pageable)
            ;

}
