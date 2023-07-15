package com.example.demo.controller;

import com.example.demo.controller.interfaces.IBaseController;
import com.example.demo.service.interfaces.IBaseService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController<T, Id> implements IBaseController<T, Id> {
    private final IBaseService<T, Id> iBaseService
            ;

    public BaseController(IBaseService<T, Id> iBaseService
    ) {
        this.iBaseService
                = iBaseService
        ;
    }

    @Override
    public ResponseEntity<T> create(T entity) {
        return ResponseEntity.ok(iBaseService.create(entity));
    }

    @Override
    public ResponseEntity<T> update(T entity, Id id) {
        return ResponseEntity.ok(iBaseService
                .update(entity, id));
    }

    @Override
    public ResponseEntity<T> getById(Id id) {
        return ResponseEntity.ok(iBaseService
                .getById(id));
    }

    @Override
    public ResponseEntity<List<T>> getList() {
        return ResponseEntity.ok(iBaseService
                .getList());
    }

    @Override
    public ResponseEntity<Boolean> delete(Id id) {
        return ResponseEntity.ok(iBaseService
                .delete(id));
    }
}
