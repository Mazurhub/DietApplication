package com.example.demo.person_measurement.api;

import com.example.demo.person_measurement.api.dto.PersonHealthMetrics;

import java.util.UUID;

public interface PersonHealthMetricFacade {
    PersonHealthMetrics getPersonHealthMetricByUserId(UUID userId);
}
