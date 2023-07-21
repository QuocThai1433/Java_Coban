package com.example.demo.service.interfaces;

import java.util.List;

public interface IBaseService<D, I> {
    D create(D entity);

    D update(D entity, I id);

    D getById(I id);

    List<D> getList();

    boolean delete(I id);
}
