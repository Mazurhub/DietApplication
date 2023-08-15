package com.example.demo.user;

import com.example.demo.person.PersonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class UserEntity {
    @Id
    private UUID id;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonEntity personEntity;
}
