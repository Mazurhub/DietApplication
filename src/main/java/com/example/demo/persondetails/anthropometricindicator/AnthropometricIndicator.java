package com.example.demo.persondetails.anthropometricindicator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnthropometricIndicator {
    private UUID id;
    private Double weight;
    private Double hight;
    private Double bmi;
    private Double pal;
    private Double ppm;
    private Double cpm;

}
