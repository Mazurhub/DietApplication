package com.example.demo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID id;
    private String name;
    private String surname;
}
