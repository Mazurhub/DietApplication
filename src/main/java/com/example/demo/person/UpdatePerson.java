package com.example.demo.person;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdatePerson {
    private UUID id;
    private String name;
    private String surname;
}
