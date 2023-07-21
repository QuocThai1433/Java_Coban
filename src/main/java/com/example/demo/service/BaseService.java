package com.example.demo.service;

import com.example.demo.dto.IBaseMapper;
import com.example.demo.service.interfaces.IBaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<E, I, D> implements IBaseService<D, I> {
    public final JpaRepository<E, I> repository;
    public final IBaseMapper<E, D> mapper;

    protected BaseService(JpaRepository<E, I> repository, IBaseMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public D create(D entity) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(entity)
                )
        );
    }

    @Override
    public D update(D entity, I id) {
        if (getById(id) == null) {
            return null;
        }
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(entity)
                )
        );
    }

    @Override
    public D getById(I id) {
        Optional<E> optional = repository.findById(id);
        return optional.map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<D> getList() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(I id) {
        repository.deleteById(id);
        return true;
    }

}
