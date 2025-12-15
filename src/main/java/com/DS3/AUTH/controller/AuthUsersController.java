package com.DS3.AUTH.controller;

import com.DS3.AUTH.entity.AuthUsers;
import com.DS3.AUTH.repository.AuthUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/authUsers")
public class AuthUsersController {
    @Autowired
    private AuthUsersRepository authUsersRepository;

     @GetMapping
    public List<AuthUsers> getAll(){
        return authUsersRepository.findAll();
    }

    @GetMapping("/{id}")
    public AuthUsers getById(@PathVariable Long id){
        return authUsersRepository.findById(id).orElse(null);
    }

    @PostMapping
    public AuthUsers create(@RequestBody AuthUsers authUsers){
        return authUsersRepository.save(authUsers);
    }

    @PutMapping("/{id}")
    public AuthUsers update(@PathVariable Long id,@RequestBody AuthUsers authUsers){
        authUsers.setId(id);
        return authUsersRepository.save(authUsers);
    }
}
