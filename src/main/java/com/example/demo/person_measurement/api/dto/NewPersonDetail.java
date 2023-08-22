package com.example.demo.person_measurement.api.dto;

import java.time.LocalDate;
import java.util.UUID;

public record NewPersonDetail(
        UUID userId,
        UUID personDetailId,
        LocalDate measurementDate,
        double weight,
        double height,
        int age,
        String sex,
        double palCoefficient,
        double bmiValue,
        double ppmValue,
        double cpmValue,
        double proteinPerGram,
        double fatPerGram,
        double carbsPerGram) {
}
