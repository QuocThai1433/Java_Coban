package com.example.demo.repository.studentrepo;

import com.example.demo.entity.Students;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepositoryCustorm {

    List<Students>  getListByFilter(String nameSort, String nameType, @Param("name") String fullName, @Param("age") Integer age,@Param("score ") Float score,@Param("address") String address );
}