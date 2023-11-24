package com.example.demo.controller;

import com.example.demo.controller.interfaces.IUserController;
import com.example.demo.service.interfaces.IUserService;
import com.example.demo.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final IUserService iUserService;
    @Override
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(iUserService.login(request));
    }

    @Override
    public ResponseEntity<RegisterResponse> register(RegisterRequest request) {
        return ResponseEntity.ok(iUserService.register(request));
    }

    @Override
    public ResponseEntity<List<Users>> getList() {
        return ResponseEntity.ok(iUserService.getList());
    }
}