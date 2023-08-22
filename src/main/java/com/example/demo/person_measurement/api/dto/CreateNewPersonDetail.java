package com.example.demo.person_measurement.api.dto;

import java.time.LocalDate;

public record CreateNewPersonDetail(
        double weight,
        double height,
        int age,
        String sex,
        PhysicalActivityLevel palCoefficient,
        LocalDate measurementDate) {
}

