package com.example.demo.person;

import com.example.demo.person.email.Email;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@Entity
@Table(name = "PersonEntity")
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity {
    @Id
    private UUID id;
    private String name;
    private String surname;
    @OneToOne
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email email;

// Comement TODO Caschade Type

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}

