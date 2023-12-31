package com.example.demo.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
class UserEntity {
    @Id
    private UUID userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
}
