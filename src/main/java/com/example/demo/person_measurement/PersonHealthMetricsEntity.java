package com.example.demo.person_measurement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
class PersonHealthMetricsEntity {
    @Id
    private UUID personHealthMetricsId;
    private double bmi;
    private double ppm;
    private double cpm;
    private double protein;
    private double fat;
    private double carbs;
}
