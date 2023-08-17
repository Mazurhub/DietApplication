package com.example.demo.person_measurement.api.dto;

public record PersonData(double weight, double height, int age, String sex, PhysicalActivityLevel palCoefficient) {
}
