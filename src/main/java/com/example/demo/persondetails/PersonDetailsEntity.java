package com.example.demo.persondetails;

import com.example.demo.persondetails.DietInformation.DietInformation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "persondetailsentity")
public class PersonDetailsEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private Double weight;
    private Double height;
    private Integer age;
    private String sex;
    private LocalDate measurementDate;
    private double bmi;
    private double ppm;
    private double cpm;
    private double protein;
    private double fat;
    private double carbs;
    private EnumPalCoefficient enumPalCoefficient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dietinformation_id", referencedColumnName = "id")
    private DietInformation dietinformation;
}
