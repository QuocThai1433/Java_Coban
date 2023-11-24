package com.example.demo.service;

import com.example.demo.keycloak.IKeycloakService;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.interfaces.IUserService;
import com.example.demo.user.*;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IKeycloakService iKeycloakService;
    private final UserRepository userRepository;


    @Override
    public LoginResponse login(LoginRequest request) {
        AccessTokenResponse accessTokenResponse = iKeycloakService.token(request.getUserName(), request.getPassword());
        return LoginResponse.builder()
            .token(accessTokenResponse.getToken())
            .expiresIn(accessTokenResponse.getExpiresIn())
            .refreshToken(accessTokenResponse.getRefreshToken())
            .refreshExpiresIn(accessTokenResponse.getRefreshExpiresIn())
            .sessionState(accessTokenResponse.getSessionState())
            .build();
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        UUID userId = iKeycloakService.register(request);
        Users user = Users.builder()
            .keycloakId(userId)
            .firstName(request.getFistName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .phoneNumber(request.getPhoneNumber())
            .build();

        userRepository.save(user);

        return RegisterResponse.builder()
            .userId(userId)
            .build();
    }

    @Override
    public List<Users> getList() {
        return userRepository.findAll();
    }
}
