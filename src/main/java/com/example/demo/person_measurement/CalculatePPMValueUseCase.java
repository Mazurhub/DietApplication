package com.example.demo.person_measurement;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class CalculatePPMValueUseCase {

    private final PersonHealthMetricsRepository personHealthMetricsRepository;
    private final PersonDataRepository personDataRepository;

    public CalculatePPMValueUseCase(PersonHealthMetricsRepository personHealthMetricsRepository, PersonDataRepository personDataRepository) {
        this.personHealthMetricsRepository = personHealthMetricsRepository;
        this.personDataRepository = personDataRepository;
    }
    void execute(UUID userId){
        var personDataEntity = personDataRepository.findById(userId).get();
        double ppm = CalculatePersonHealthMetric.calculatePPM(personDataEntity.getWeight(), personDataEntity.getHeight(), personDataEntity.getAge(), personDataEntity.getSex());
        var personHealthMetricEntity = new PersonHealthMetricsEntity();
        personHealthMetricEntity.setPpm(ppm);
        var personHealthMetricEntitySave = personHealthMetricsRepository.save(personHealthMetricEntity);
    }
}
