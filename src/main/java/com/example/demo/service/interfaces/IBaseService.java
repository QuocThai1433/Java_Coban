package com.example.demo.service.interfaces;

import org.yaml.snakeyaml.events.Event;

import java.util.List;

public interface IBaseService <T,Id>{
    T create(T entity);

    T update (T entity, Id id);

    T getById(Id id);
    
    List<T> getList ();

    boolean delete (Id id);
}
