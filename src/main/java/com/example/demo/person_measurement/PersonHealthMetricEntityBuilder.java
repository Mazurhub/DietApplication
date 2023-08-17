package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.PhysicalActivityLevel;

class PersonHealthMetricEntityBuilder {
    private double bmi;
    private double ppm;
    private double cpm;
    private double protein;
    private double fat;
    private double carbs;

    PersonHealthMetricEntityBuilder calculateMetrics(PersonDataEntity personDataEntity) {
        double weight = personDataEntity.getWeight();
        double height = personDataEntity.getHeight();
        int age = personDataEntity.getAge();
        String sex = personDataEntity.getSex();
        PhysicalActivityLevel palCoefficient = personDataEntity.getPalCoefficient();

        bmi = CalculatePersonHealthMetric.calculateBMI(weight, height);
        ppm = CalculatePersonHealthMetric.calculatePPM(weight, height, age, sex);
        cpm = CalculatePersonHealthMetric.calculateCPM(ppm, palCoefficient);
        protein = CalculatePersonHealthMetric.calculateProteinPerGram(cpm);
        fat = CalculatePersonHealthMetric.calculateFatPerGram(cpm);
        carbs = CalculatePersonHealthMetric.calculateCarbsPerGram(cpm);

        return this;
    }

    PersonHealthMetricsEntity build() {
        PersonHealthMetricsEntity entity = new PersonHealthMetricsEntity();
        entity.setBmi(bmi);
        entity.setPpm(ppm);
        entity.setCpm(cpm);
        entity.setProtein(protein);
        entity.setCarbs(carbs);
        entity.setFat(fat);
        return entity;
    }
}

