package com.example.demo.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String name;
    private String surname;
}
