package com.example.demo.controller;

import com.example.demo.controller.interfaces.IBaseController;
import com.example.demo.service.interfaces.IBaseService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController<T, Id> implements IBaseController<T, Id> {
    private final IBaseService<T, Id> idIBaseService;

    public BaseController(IBaseService<T, Id> idIBaseService) {
        this.idIBaseService = idIBaseService;
    }

    @Override
    public ResponseEntity<T> create(T entity) {
        return ResponseEntity.ok(idIBaseService.create(entity));
    }

    @Override
    public ResponseEntity<T> update(T entity, Id id) {
        return ResponseEntity.ok(idIBaseService.update(entity, id));
    }

    @Override
    public ResponseEntity<T> getById(Id id) {
        return ResponseEntity.ok(idIBaseService.getById(id));
    }

    @Override
    public ResponseEntity<List<T>> getList() {
        return ResponseEntity.ok(idIBaseService.getList());
    }

    @Override
    public ResponseEntity<Boolean> delete(Id id) {
        return ResponseEntity.ok(idIBaseService.delete(id));
    }
}
