package com.DS3.AUTH.repository;

import com.DS3.AUTH.entity.AuthUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUsersRepository extends JpaRepository<AuthUsers, Long> {
    AuthUsers findByEmail(String email);
}
