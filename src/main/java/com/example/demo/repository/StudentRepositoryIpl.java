package com.example.demo.repository;

import com.example.demo.entity.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentRepositoryIpl implements IStudentRepositoryCustorm {
    public final EntityManager entityManager;

    @Override
    public List<Students> getByFilter(String nameSort,String nameType, String fullName, Integer age, Float score, String address) {

        String query = "select * from students where if(:name is null, true ,name =:name) and if(:age is null, true ,age =:age) and if(:score is null, true ,score =:score) and  if(:address is null, true ,address =:address)  order by   ";



  if(nameSort.equals("name "))
  {
      query = query + "name";
      if (nameType.equals("asc"))
      {
          query = query + "asc";
      }else
      {
          query = query +"desc";
      }
  }
  else {
      query = query + "age ";
      if (nameType.equals("asc"))
      {
          query = query + "asc";
      }else
      {
          query = query +"desc";
      }

  }
        Query typeQuery = entityManager.createNativeQuery(query,Students.class);
        typeQuery.setParameter("name", fullName);
        typeQuery.setParameter("age", age);
        typeQuery.setParameter("score", score);
        typeQuery.setParameter("address", address);

        return typeQuery.getResultList();
    }
}
