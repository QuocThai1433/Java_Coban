package com.example.demo.service.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T, I extends Serializable> {
    T create(T entity);

    T update(T entity, I id);

    T getById(I id);

    List<T> getList();

    boolean delete(I id);
}
