package com.example.demo.person_measurement;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class CalculateCarbsValueUseCase {

    private final PersonHealthMetricsRepository personHealthMetricsRepository;
    private final PersonDataRepository personDataRepository;

    public CalculateCarbsValueUseCase(PersonHealthMetricsRepository personHealthMetricsRepository, PersonDataRepository personDataRepository) {
        this.personHealthMetricsRepository = personHealthMetricsRepository;
        this.personDataRepository = personDataRepository;
    }

    void execute(UUID userId) {
        var personDataEntity = personDataRepository.findById(userId).get();
        var personHealthMetric = personHealthMetricsRepository.findById(userId).get();
        double carbsPerGram = CalculatePersonHealthMetric.calculateCarbsPerGram(personHealthMetric.getCpm());
        var personHealthMetricEntity = new PersonHealthMetricsEntity();
        personHealthMetricEntity.setProtein(carbsPerGram);
        var personHealthMetricEntitySave = personHealthMetricsRepository.save(personHealthMetricEntity);
    }
}
