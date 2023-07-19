package com.example.demo.persondetails.anthropometricindicator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AnthropometricIndicatorEntity {
    @Id
    private UUID id;
    private Double weight;
    private Double hight;
    private Double bmi;
    private Double pal;
    private Double ppm;
    private Double cpm;
}
