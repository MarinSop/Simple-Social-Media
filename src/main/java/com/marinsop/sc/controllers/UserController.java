package com.marinsop.sc.controllers;

import com.marinsop.sc.entities.User;
import com.marinsop.sc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService ser;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAll()
    {
        return ResponseEntity.ok(ser.getAll());
    }

}
