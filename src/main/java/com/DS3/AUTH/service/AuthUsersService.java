package com.DS3.AUTH.service;

import com.DS3.AUTH.entity.AuthUsers;
import com.DS3.AUTH.repository.AuthUsersRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthUsersService {

    private AuthUsersRepository authUsersRepository;

    public AuthUsersService(AuthUsersRepository authUsersRepository) {
        this.authUsersRepository = authUsersRepository;
    }

    public String login(String email, String password) {
        AuthUsers user = authUsersRepository.findByEmail(email);

        if(!user.getPassword().equals(password)){
            return "Incorrect password";
        }

        return UUID.randomUUID().toString();
    }
}
