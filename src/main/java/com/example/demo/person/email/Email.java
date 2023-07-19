package com.example.demo.person.email;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;

    public Email(String email) {
        this.email = email;
    }
}
