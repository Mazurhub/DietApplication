package com.example.demo.person_measurement.api;

import com.example.demo.person_measurement.api.dto.CreatePersonData;
import com.example.demo.person_measurement.api.dto.PersonData;

import java.util.UUID;

public interface PersonDataFacade {
    PersonData createPersonDataByUserId(CreatePersonData createPersonData);

    PersonData getPersonDataByUserId(UUID userId);
}
