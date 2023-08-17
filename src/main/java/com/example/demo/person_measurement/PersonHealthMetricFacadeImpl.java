package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.PersonHealthMetricFacade;
import com.example.demo.person_measurement.api.dto.PersonHealthMetrics;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class PersonHealthMetricFacadeImpl implements PersonHealthMetricFacade {

    @Override
    public PersonHealthMetrics getPersonHealthMetricByUserId(UUID userId) {
        var personHealthMetrics = getPersonHealthMetricByUserId(userId);

    }
}
