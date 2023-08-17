package com.example.demo.person_measurement;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class CalculateBmiValueUseCase {

    private final PersonHealthMetricsRepository personHealthMetricsRepository;
    private final PersonDataRepository personDataRepository;

    CalculateBmiValueUseCase(PersonHealthMetricsRepository personHealthMetricsRepository, PersonDataRepository personDataRepository) {
        this.personHealthMetricsRepository = personHealthMetricsRepository;
        this.personDataRepository = personDataRepository;
    }
    void execute(UUID userId) {
        var personDataEntity = personDataRepository.findById(userId).get();
        double bmi = CalculatePersonHealthMetric.calculateBMI(personDataEntity.getWeight(), personDataEntity.getHeight());
        var personHealthMetricEntity = new PersonHealthMetricsEntity();
        personHealthMetricEntity.setBmi(bmi);
        var personHealthMetricEntitySave = personHealthMetricsRepository.save(personHealthMetricEntity);
    }
}






