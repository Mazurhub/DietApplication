package com.example.demo.person_measurement.api;

import com.example.demo.person_measurement.NewPersonDetailEntity;
import com.example.demo.person_measurement.api.dto.CreateNewPersonDetail;
import com.example.demo.person_measurement.api.dto.CreatePersonDetailsHistory;
import com.example.demo.person_measurement.api.dto.NewPersonDetail;

import java.util.List;
import java.util.UUID;

public interface PersonMeasurementFacade {
    void createPersonDetailsHistoryByUserId(CreatePersonDetailsHistory createPersonDetailsHistory);
    NewPersonDetail addNewPersonDetail(UUID userId, CreateNewPersonDetail createNewPersonDetail);
    List<NewPersonDetail> getPersonDetailsHistory(UUID userId);
    NewPersonDetail getCurrentPersonDetailByUserId(UUID userId);
}
