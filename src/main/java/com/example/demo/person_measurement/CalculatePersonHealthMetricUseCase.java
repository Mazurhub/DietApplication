package com.example.demo.person_measurement;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class CalculatePersonHealthMetricUseCase {

    private final PersonDataRepository personDataRepository;
    private final PersonHealthMetricsRepository personHealthMetricsRepository;

    public CalculatePersonHealthMetricUseCase(PersonDataRepository personDataRepository, PersonHealthMetricsRepository personHealthMetricsRepository) {
        this.personDataRepository = personDataRepository;
        this.personHealthMetricsRepository = personHealthMetricsRepository;
    }
    void execute(UUID userId) {
        var personDataEntity = personDataRepository.findById(userId).get();
        PersonHealthMetricsEntity personHealthMetricEntity = new PersonHealthMetricEntityBuilder()
                .calculateMetrics(personDataEntity)
                .build();
        personHealthMetricsRepository.save(personHealthMetricEntity);
    }
}
