package com.example.demo.repository;

import com.example.demo.entity.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentRepositoryIpl implements IStudentRepositoryCustorm {
    public final EntityManager entityManager;
    
    @Override
    public List<Students> getByFilter(String nameSortType) {
        String query = "select * from students where name = :name order by name ";
        if (nameSortType.equals("asc")) {
            query = query + "asc";
        } else {
            query = query + "desc";
        }
        Query typedQuery = entityManager.createNativeQuery(query, Students.class);
        typedQuery.setParameter("name", "thai");
        return typedQuery.getResultList();
    }
}
