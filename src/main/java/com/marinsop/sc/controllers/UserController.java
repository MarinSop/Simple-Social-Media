package com.marinsop.sc.controllers;

import com.marinsop.sc.dtos.LoginDTO;
import com.marinsop.sc.dtos.LoginResponse;
import com.marinsop.sc.dtos.RegisterDTO;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAll()
    {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authentication(@RequestBody LoginDTO loginDto)
    {
       return ResponseEntity.ok(userService.authentication(loginDto));
    }


}
