package com.DS3.AUTH.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // facilita pruebas con Postman/Requestly
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/authUsers/**").permitAll() // login/registro públicos
                        .anyRequest().authenticated()                // el resto requiere auth
                )
                .httpBasic(Customizer.withDefaults()); // o .formLogin().disable() si no quieres formulario

        return http.build();
    }
}
