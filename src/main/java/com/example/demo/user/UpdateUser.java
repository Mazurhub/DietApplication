package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateUser {
    private UUID id;
    private String userName;
    private String password;
    private String email;
    private int phoneNumber;
}
