package com.example.demo.repository;

import com.example.demo.entity.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentRepositoryIpl implements IStudentRepositoryCustorm {
    public final EntityManager entityManager;
    @Override
    public List<Students> getByFilter(String nameSortType) {
        String query ="select * from students order by name ";
        if (nameSortType.equals("asc"))
        {
            query = query + "asc";
        }else
        {
            query = query +"desc";
        }
        TypedQuery<Students> typedQuery = entityManager.createQuery(query,Students.class);
        return typedQuery.getResultList();
    }
}
