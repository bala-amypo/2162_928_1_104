package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public UserAccount login(@RequestBody UserAccount user) {
        return authService.login(user);
    }
}
