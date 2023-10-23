package com.macsenh.SpringBootProject.security.controller;

import com.macsenh.SpringBootProject.security.service.AuthService;
import com.macsenh.SpringBootProject.system.LoginRequest;
import com.macsenh.SpringBootProject.system.StatusCode;
import com.macsenh.SpringBootProject.system.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Result getLoginInfo(@RequestBody LoginRequest loginRequest){
        return new Result(true,
                StatusCode.SUCCESS,
                "Userinfo and JWT Token",
                authService.createLoginInfo(loginRequest));
    }
}
