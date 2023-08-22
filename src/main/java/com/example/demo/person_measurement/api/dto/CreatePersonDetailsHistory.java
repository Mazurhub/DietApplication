package com.example.demo.person_measurement.api.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CreatePersonDetailsHistory(
        UUID userId,
        double weight,
        double height,
        int age,
        String sex,
        PhysicalActivityLevel palCoefficient,
        double bmi,
        double ppm,
        double cpm,
        double protein,
        double fat,
        double carbs,
        LocalDate measurementDate){
}
