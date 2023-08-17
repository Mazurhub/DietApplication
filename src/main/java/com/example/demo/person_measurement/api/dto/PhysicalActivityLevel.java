package com.example.demo.person_measurement.api.dto;

public enum PhysicalActivityLevel {
    PAL_1(1.2),
    PAL_2(1.4),
    PAL_3(1.6),
    PAL_4(1.8),
    PAL_5(2.0);

    PhysicalActivityLevel(double palCoefficient) {
        this.palCoefficient = palCoefficient;
    }
    private final double palCoefficient;

    public double getPalCoefficient() {
        return palCoefficient;
    }
}
