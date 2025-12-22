package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.User;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public User register(User user) {
        // TEMP LOGIC (no DB yet)
        user.setId(1L);
        user.setActive(true);
        user.setRole("USER");
        return user;
    }

    @Override
    public User login(User user) {
        // TEMP LOGIC
        if ("admin@gmail.com".equals(user.getEmail())
                && "admin".equals(user.getPassword())) {

            user.setId(1L);
            user.setRole("ADMIN");
            user.setActive(true);
            return user;
        }

        throw new RuntimeException("Invalid credentials");
    }
}
