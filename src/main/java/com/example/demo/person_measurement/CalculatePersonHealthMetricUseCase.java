package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.CreateNewPersonDetail;
import org.springframework.stereotype.Component;

@Component
class CalculatePersonHealthMetricUseCase {

    private final PersonDetailsHistoryRepository personDetailsHistoryRepository;

    CalculatePersonHealthMetricUseCase(PersonDetailsHistoryRepository personDetailsHistoryRepository) {
        this.personDetailsHistoryRepository = personDetailsHistoryRepository;
    }

    void calculateMetrics(CreateNewPersonDetail createNewPersonDetail, NewPersonDetailEntity newPersonDetailEntity) {
        double bmi = CalculatePersonHealthMetric.calculateBMI(createNewPersonDetail.weight(), createNewPersonDetail.height());
        double ppm = CalculatePersonHealthMetric.calculatePPM(createNewPersonDetail.weight(), createNewPersonDetail.height(), createNewPersonDetail.age(), createNewPersonDetail.sex());
        double cpm = CalculatePersonHealthMetric.calculateCPM(ppm, createNewPersonDetail.palCoefficient());
        double protein = CalculatePersonHealthMetric.calculateProteinPerGram(cpm);
        double fat = CalculatePersonHealthMetric.calculateFatPerGram(cpm);
        double carbs = CalculatePersonHealthMetric.calculateCarbsPerGram(cpm);

        newPersonDetailEntity.setBmi(bmi);
        newPersonDetailEntity.setPpm(ppm);
        newPersonDetailEntity.setCpm(cpm);
        newPersonDetailEntity.setProtein(protein);
        newPersonDetailEntity.setFat(fat);
        newPersonDetailEntity.setCarbs(carbs);

    }
}
