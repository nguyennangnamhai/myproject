package com.macsenh.SpringBootProject.security.service;

import com.macsenh.SpringBootProject.entity.User;
import com.macsenh.SpringBootProject.repository.UserRepository;
import com.macsenh.SpringBootProject.system.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public AuthService(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    public Map<String, Object> createLoginInfo(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow();
        String jwtToken = jwtProvider.generateToken(user);
        Map<String, Object> loginResultMap = new HashMap<>();
        loginResultMap.put("username",user.getUsername());
        loginResultMap.put("Token",jwtToken);
        return loginResultMap;
    }
}
