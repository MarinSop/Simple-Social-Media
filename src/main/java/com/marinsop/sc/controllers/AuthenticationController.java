package com.marinsop.sc.controllers;

import com.marinsop.sc.dtos.LoginDTO;
import com.marinsop.sc.dtos.LoginResponse;
import com.marinsop.sc.dtos.RegisterDTO;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(LoginDTO loginDto)
    {
        return ResponseEntity.ok(userService.authentication(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerDto)
    {
        return ResponseEntity.ok(userService.register(registerDto));
    }
}
