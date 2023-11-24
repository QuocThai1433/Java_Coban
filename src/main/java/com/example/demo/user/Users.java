package com.example.demo.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String fullName;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String phoneNumber;


    private Integer moviePackageId;

    private String namePro;


    @Column(updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID keycloakId;
}
