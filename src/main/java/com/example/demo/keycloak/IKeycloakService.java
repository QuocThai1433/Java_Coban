package com.example.demo.keycloak;

import com.example.demo.user.RegisterRequest;
import org.keycloak.representations.AccessTokenResponse;

import java.util.UUID;

public interface IKeycloakService {

    UUID register (RegisterRequest request);

    AccessTokenResponse token(String username, String password);
}