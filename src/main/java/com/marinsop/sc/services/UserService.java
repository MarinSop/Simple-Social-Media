package com.marinsop.sc.services;

import com.marinsop.sc.dtos.LoginDTO;
import com.marinsop.sc.dtos.LoginResponse;
import com.marinsop.sc.dtos.RegisterDTO;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;


    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public LoginResponse authentication(LoginDTO loginDto)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),loginDto.getPassword()
        ));

        User user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new LoginResponse(token,jwtService.getExpirationTime());
    }

    public User register(RegisterDTO registerDto)
    {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setBio(registerDto.getBio());
        userRepository.save(user);
        return user;
    }
}


