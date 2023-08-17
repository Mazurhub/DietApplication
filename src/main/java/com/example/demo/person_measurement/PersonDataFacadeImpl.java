package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.PersonDataFacade;
import com.example.demo.person_measurement.api.dto.CreatePersonData;
import com.example.demo.person_measurement.api.dto.PersonData;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class PersonDataFacadeImpl implements PersonDataFacade {

    private final CreatePersonDataUseCase createPersonDataUseCase;
    private final GetPersonDataByUserIdUseCase getPersonDataByUserIdUseCase;

    PersonDataFacadeImpl(CreatePersonDataUseCase createPersonDataUseCase, GetPersonDataByUserIdUseCase getPersonDataByUserIdUseCase) {
        this.createPersonDataUseCase = createPersonDataUseCase;
        this.getPersonDataByUserIdUseCase = getPersonDataByUserIdUseCase;
    }

    @Override
    public PersonData createPersonDataByUserId(CreatePersonData createPersonData) {
        var userId = createPersonDataUseCase.execute(createPersonData);
        return getPersonDataByUserId(userId);
    }

    public PersonData getPersonDataByUserId(UUID userId) {
        return getPersonDataByUserIdUseCase.execute(userId);
    }
}
