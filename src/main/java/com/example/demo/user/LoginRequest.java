package com.example.demo.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class LoginRequest {

    private String userName;

    private String password;

}
