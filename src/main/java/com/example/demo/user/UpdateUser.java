package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateUser {
    private UUID id;
    private String name;
    private String surname;
}
