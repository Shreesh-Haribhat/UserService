package com.UserService.AuthService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Allow all requests without authentication, disable CORS and CSRF
        http
                .authorizeHttpRequests(requests ->
                        requests.anyRequest().permitAll()
                )
                .cors(cors -> cors.disable())  // Disable CORS
                .csrf(csrf -> csrf.disable());  // Disable CSRF

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder getBcryptEncoder()
    {
        return new BCryptPasswordEncoder();
    }


}
