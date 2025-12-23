package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userRepo;

    public AuthServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount register(UserAccount user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("email already exists");
        }
        user.setActive(true);
        return userRepo.save(user);
    }

    @Override
    public UserAccount login(String email, String password) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("invalid credentials"));
    }
}
