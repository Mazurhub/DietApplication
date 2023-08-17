package com.example.demo.person_measurement.api.dto;

import java.util.UUID;

public record CreatePersonData(UUID userId, double weight, double height, int age, String sex, PhysicalActivityLevel palCoefficient) {

}
