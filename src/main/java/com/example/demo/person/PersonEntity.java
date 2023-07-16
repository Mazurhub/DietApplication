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
@Table(name = "person")
@Getter
@Setter

public class PersonEntity {
    @Id
    @Column(name = "person_id")
    private UUID id;
    private String name;
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_person_contact_id")
    private PersonContactEntity personContactEntity;
}
