package com.example.demo.service;

import com.example.demo.service.interfaces.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public  abstract  class BaseService<T,Id> implements IBaseService<T, Id> {
    public final JpaRepository<T,Id> repository;

    protected BaseService(JpaRepository<T, Id> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity, Id id) {
        if(getById(id)==null)
        {
            return  null;
        }
        return repository.save(entity);
    }

    @Override
    public T getById(Id id) {
        Optional<T> optional = repository.findById(id);
        if(optional.isEmpty())
        {
            return null;
        }
       return optional.get();
    }

    @Override
    public List<T> getList() {
        return repository.findAll();
    }

    @Override
    public boolean delete(Id id) {
         repository.deleteById(id);
        return  true;
    }
}
