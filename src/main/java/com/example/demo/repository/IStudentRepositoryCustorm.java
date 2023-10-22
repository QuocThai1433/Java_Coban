package com.example.demo.repository;

import com.example.demo.entity.Students;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IStudentRepositoryCustorm {
    List<Students> getByFilter (String nameSortType);
}
