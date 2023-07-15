package com.example.demo.service;

import com.example.demo.service.interfaces.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, I extends Serializable> implements IBaseService<T, I> {
    public final JpaRepository<T, I> repository;

    protected BaseService(JpaRepository<T, I> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity, I id) {
        if (getById(id) == null) {
            return null;
        }
        return repository.save(entity);
    }

    @Override
    public T getById(I id) {
        Optional<T> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<T> getList() {
        return repository.findAll();
    }

    @Override
    public boolean delete(I id) {
        repository.deleteById(id);
        return true;
    }
}
