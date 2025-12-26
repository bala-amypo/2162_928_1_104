package com.example.demo.service;

import com.example.demo.model.UserAccount;

public interface AuthService {

    String register(UserAccount user);

    String login(UserAccount user);
}
