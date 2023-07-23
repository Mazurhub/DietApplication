package com.example.demo.persondetails;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePersonDetails {
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