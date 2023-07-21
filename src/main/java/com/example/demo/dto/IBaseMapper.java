package com.example.demo.dto;

public interface IBaseMapper<E, D> {
    E toEntity(D dto);

    D toDto(E entity);
}
