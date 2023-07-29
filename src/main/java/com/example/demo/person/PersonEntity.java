package com.example.demo.person;

import com.example.demo.persondetails.PersonDetailsEntity;
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
    private String mail;
    private Integer phoneNumber;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "persondetailsentity_id", referencedColumnName = "id")
    private PersonDetailsEntity persondetailsentity;

}

