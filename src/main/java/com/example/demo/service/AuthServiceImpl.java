package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repo;

    public AuthServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount register(UserAccount user) {
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }
        user.setActive(true);
        return repo.save(user);
    }

    @Override
    public UserAccount login(UserAccount user) {
        return repo.findByEmail(user.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));
    }
}
