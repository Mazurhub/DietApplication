package com.example.demo.persondetails.anthropometricindicator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnthropometricIndicator {
    private UUID id;
    private Double weight;
    private Double hight;
    private Integer age;
    private String sex;
    private LocalDate measurementDate;
    private String bmi;
    private String ppm;

}
