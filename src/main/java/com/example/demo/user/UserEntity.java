package com.example.demo.user;

import com.example.demo.person.PersonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
//odwzorowanie bazodanowe co sie tutaj dzieje.
@Getter
@Setter
public class UserEntity {
    @Id
    private UUID id;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private int phoneNumber;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonEntity personEntity;
}
