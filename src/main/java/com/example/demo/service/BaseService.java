package com.example.demo.service;

import com.example.demo.dto.StudentMapper;
import com.example.demo.service.interfaces.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID> implements IBaseService<T, ID> {
    public final JpaRepository<T, ID> repository;

    public final StudentMapper mapper;

    protected BaseService(JpaRepository<T, ID> repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }



    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity, ID id) {
        if (getById(id) == null) {
            return null;
        }
        return repository.save(entity);
    }

    @Override
    public T getById(ID id) {
        Optional<T> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<T> getList() {
        return repository.findAll();
    }

    @Override
    public boolean delete(ID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public T createDTO(T entity) {
        return repository.save(entity);
    }


}
