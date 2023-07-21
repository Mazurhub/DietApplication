package com.example.demo.persondetails.anthropometricindicator;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateAnthropometricIndicator {
    private Double weight;
    private Double hight;
    private Integer age;
    private String sex;
    private LocalDate measurementDate;
    private String bmi;
    private String ppm;

}
