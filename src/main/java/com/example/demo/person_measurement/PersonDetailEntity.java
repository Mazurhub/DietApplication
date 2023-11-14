package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.PhysicalActivityLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "PersonDetailEntity")
@Getter
class PersonDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID personDetailId;
    private double weight;
    private double height;
    private int age;
    private String sex;
    private PhysicalActivityLevel palCoefficient;
    private LocalDate measurementDate;
    private double bmi;
    private double ppm;
    private double cpm;
    private double protein;
    private double fat;
    private double carbs;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_history_id")
    private PersonDetailsHistoryEntity personDetailsHistory;

    public PersonDetailEntity(double weight, double height, int age, String sex, PhysicalActivityLevel palCoefficient, LocalDate measurementDate, PersonDetailsHistoryEntity personDetailsHistory) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.palCoefficient = palCoefficient;
        this.measurementDate = measurementDate;
        this.personDetailsHistory = personDetailsHistory;
    }

    public PersonDetailEntity() {
    }

    void setBmi(double bmi) {
        this.bmi = bmi;
    }

    void setPpm(double ppm) {
        this.ppm = ppm;
    }

    void setCpm(double cpm) {
        this.cpm = cpm;
    }

    void setProtein(double protein) {
        this.protein = protein;
    }

    void setFat(double fat) {
        this.fat = fat;
    }

    void setCarbs(double carbs) {
        this.carbs = carbs;
    }
}
