package com.example.demo.person_measurement.api.dto;

import java.util.UUID;

public record CreatePersonHealthMetrics(UUID userId, double bmi, double ppm, double cpm, double protein, double fat, double carbs) {
}
