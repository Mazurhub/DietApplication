package com.example.demo.person_measurement;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class CalculateCPMValueUseCase {
    private final PersonHealthMetricsRepository personHealthMetricsRepository;
    private final PersonDataRepository personDataRepository;

    public CalculateCPMValueUseCase(PersonHealthMetricsRepository personHealthMetricsRepository, PersonDataRepository personDataRepository) {
        this.personHealthMetricsRepository = personHealthMetricsRepository;
        this.personDataRepository = personDataRepository;
    }
    void execute(UUID userId){
        var personDataEntity = personDataRepository.findById(userId).get();
        var personHealthMetric = personHealthMetricsRepository.findById(userId).get();
        double cpm = CalculatePersonHealthMetric.calculateCPM(personHealthMetric.getPpm(), personDataEntity.getPalCoefficient());
        var personHealthMetricEntity = new PersonHealthMetricsEntity();
        personHealthMetricEntity.setCpm(cpm);
        var personHealthMetricEntitySave = personHealthMetricsRepository.save(personHealthMetricEntity);
    }
}
