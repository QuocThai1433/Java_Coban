package com.example.demo.controller.interfaces;

import com.example.demo.user.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/v1/user")
public interface IUserController {
    @PostMapping("login")
    @SecurityRequirements
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request);

    @PostMapping("register")
    @SecurityRequirements
    ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request);

    @GetMapping("list")
    ResponseEntity<List<Users>> getList();
}
