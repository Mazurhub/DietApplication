package com.example.demo.person;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "person_contact")
@Getter
@Setter

public class PersonContactEntity {
    @Id
    @GeneratedValue
    @Column(name = "person_contact_id")
    private UUID id;
    private String email;
}
