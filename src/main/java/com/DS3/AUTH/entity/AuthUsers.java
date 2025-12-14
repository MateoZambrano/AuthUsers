package com.DS3.AUTH.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "authUsers")
public class AuthUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is requested")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password is requested")
    private String password;
}
