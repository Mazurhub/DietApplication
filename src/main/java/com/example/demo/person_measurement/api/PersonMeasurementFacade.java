package com.example.demo.person_measurement.api;

import com.example.demo.person_measurement.api.dto.CreateNewPersonDetail;
import com.example.demo.person_measurement.api.dto.CreatePersonDetailsHistory;
import com.example.demo.person_measurement.api.dto.NewPersonDetail;

import java.util.UUID;

public interface PersonMeasurementFacade {
    void createPersonDetailsHistoryByUserId(CreatePersonDetailsHistory createPersonDetailsHistory);
    NewPersonDetail addNewPersonDetail(UUID userId, CreateNewPersonDetail createNewPersonDetail);
}
