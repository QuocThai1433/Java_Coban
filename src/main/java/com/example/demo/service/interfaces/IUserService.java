package com.example.demo.service.interfaces;

import com.example.demo.user.*;

import java.util.List;

public interface IUserService {
    LoginResponse login(LoginRequest request);

    RegisterResponse register(RegisterRequest request);

    List<Users> getList();
}
