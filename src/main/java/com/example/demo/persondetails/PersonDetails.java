package com.example.demo.persondetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"bmi", "ppm", "cpm", "protein", "fat", "carbs"})
public class PersonDetails {
    private UUID id;
    private Double weight;
    private Double height;
    private Integer age;
    private String sex;
    private double bmi;
    private double ppm;
    private double cpm;
    private double protein;
    private double fat;
    private double carbs;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EnumPalCoefficient enumPalCoefficient;

    public Double getEnumPalCoefficient() {
        return enumPalCoefficient.getCoefficientAsString();
    }
}

