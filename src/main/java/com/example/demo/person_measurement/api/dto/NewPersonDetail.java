package com.example.demo.person_measurement.api.dto;

import java.time.LocalDate;
import java.util.UUID;

public record NewPersonDetail(
        UUID userId,
        double weight,
        double height,
        int age,
        String sex,
        PhysicalActivityLevel palCoefficient,
        LocalDate measurementDate) {
}
