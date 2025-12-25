package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(UserAccount userAccount) {
        return jwtTokenProvider.generateToken(userAccount.getEmail());
    }
}
