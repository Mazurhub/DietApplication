package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.PersonHealthMetrics;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class GetPersonHealthMetricUseCase {

    private final PersonHealthMetricsRepository personHealthMetricsRepository;

    GetPersonHealthMetricUseCase(PersonHealthMetricsRepository personHealthMetricsRepository) {
        this.personHealthMetricsRepository = personHealthMetricsRepository;
    }
    PersonHealthMetrics execute(UUID userId){
        var personHealthMetricsEntity = personHealthMetricsRepository.findById(userId).get();
        return new PersonHealthMetrics(
                personHealthMetricsEntity.getBmi(),
                personHealthMetricsEntity.getPpm(),
                personHealthMetricsEntity.getCpm(),
                personHealthMetricsEntity.getProtein(),
                personHealthMetricsEntity.getFat(),
                personHealthMetricsEntity.getCarbs());
    }
}
