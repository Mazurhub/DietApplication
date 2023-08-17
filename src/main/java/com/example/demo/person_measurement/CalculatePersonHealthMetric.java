package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.PhysicalActivityLevel;

class CalculatePersonHealthMetric {

    static double calculateBMI(double weight, double height) {
        double heightInMeters = height / 100.0;
        double bmi = weight / (height * height);
        return bmi;
    }

    static double calculatePPM(double weight, double height, int age, String sex) {
        double ppm = 0;
        if (sex.equals("Women")) {
            ppm = 655.1 + (9.563 * weight + (1.85 * height) - (4.676 * age));
        } else if (sex.equals("Man")) {
            ppm = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
        } else {
            throw new IllegalArgumentException("Incorrect sex, please check and try again");
        }
        return ppm;
    }

    static double calculateCPM(double ppm, PhysicalActivityLevel palCoefficient) {
        double cpm = switch (palCoefficient) {
            case PAL_1 -> ppm * 1.2;
            case PAL_2 -> ppm * 1.4;
            case PAL_3 -> ppm * 1.6;
            case PAL_4 -> ppm * 1.8;
            case PAL_5 -> ppm * 2.0;
        };
        return cpm;
    }

    static double calculateProteinPerGram(double cpm) {
        double proteinKcal = (cpm / 100) * 10;
        double proteinPerGram = proteinKcal / 4;
        return proteinPerGram;
    }

    static double calculateFatPerGram(double cpm) {
        double fatKcal = (cpm / 100) * 30;
        double fatPerGram = fatKcal / 9;
        return fatPerGram;
    }

    static double calculateCarbsPerGram(double cpm) {
        double carbsKcal = (cpm / 100) * 60;
        double carbsPerGram = carbsKcal / 4;
        return carbsPerGram;
    }
}
