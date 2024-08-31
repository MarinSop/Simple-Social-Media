package com.marinsop.sc.services;

import com.marinsop.sc.entities.User;
import com.marinsop.sc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository rep;

    public List<User> getAll()
    {
        return rep.findAll();
    }
}
