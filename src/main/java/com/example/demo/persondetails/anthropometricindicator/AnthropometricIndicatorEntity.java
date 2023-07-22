package com.example.demo.persondetails.anthropometricindicator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AnthropometricIndicatorEntity {
    @Id
    private UUID id;
    private Double weight;
    private Double height;
    private Integer age;
    private String sex;
    private LocalDate measurementDate;
    private String bmi;
    private String ppm;
    private String cpm;
    private EnumPalCoefficient enumPalCoefficient;

}
