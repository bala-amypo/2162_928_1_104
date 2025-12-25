package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register user
    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody UserAccount user) {
        return ResponseEntity.ok(authService.register(user));
    }

    // Login -> returns JWT token (String)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAccount user) {
        return ResponseEntity.ok(authService.login(user));
    }
}
