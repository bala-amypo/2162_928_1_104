package com.example.demo.service.impl;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repo;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserAccountRepository repo, JwtTokenProvider jwtTokenProvider) {
        this.repo = repo;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public UserAccount register(UserAccount user) {
        return repo.save(user);
    }

    @Override
    public String login(UserAccount user) {
        return jwtTokenProvider.generateToken(user.getEmail());
    }
}
