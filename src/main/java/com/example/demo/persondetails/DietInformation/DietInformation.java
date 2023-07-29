package com.example.demo.persondetails.DietInformation;

import com.example.demo.persondetails.PersonDetailsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dietinformation")
public class DietInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private double ppm;
    private double cpm;
    private double protein;
    private double fat;
    private double carbs;

    @OneToOne(mappedBy = "dietinformation")
    private PersonDetailsEntity personDetailsEntity;
}
