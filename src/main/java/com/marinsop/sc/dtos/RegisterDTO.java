package com.marinsop.sc.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDTO {
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String bio;
}
