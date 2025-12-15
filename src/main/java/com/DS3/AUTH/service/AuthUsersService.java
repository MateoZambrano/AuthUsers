package com.DS3.AUTH.service;

import com.DS3.AUTH.entity.AuthUsers;
import com.DS3.AUTH.repository.AuthUsersRepository;
import com.DS3.AUTH.security.JwtTokenProvider;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthUsersService {

    private final AuthUsersRepository authUsersRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthUsersService(AuthUsersRepository authUsersRepository,
                            JwtTokenProvider jwtTokenProvider) {
        this.authUsersRepository = authUsersRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String login(String email, String password) {
        AuthUsers user = authUsersRepository.findByEmail(email);

        if (user == null) {
            return "User not found";
        }

        if (!user.getPassword().equals(password)) {
            return "Incorrect password";
        }

        // Aquí se genera el JWT
        return jwtTokenProvider.generateToken(email);
    }
}

