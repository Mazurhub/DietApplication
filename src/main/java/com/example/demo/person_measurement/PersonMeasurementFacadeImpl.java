package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.PersonMeasurementFacade;
import com.example.demo.person_measurement.api.dto.CreateNewPersonDetail;
import com.example.demo.person_measurement.api.dto.CreatePersonDetailsHistory;
import com.example.demo.person_measurement.api.dto.NewPersonDetail;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class PersonMeasurementFacadeImpl implements PersonMeasurementFacade {

    private final CreatePersonDetailsHistoryUseCase createPersonDetailsHistoryUseCase;
    private final AddNewPersonDetailUseCase addNewPersonDetailUseCase;

    PersonMeasurementFacadeImpl(CreatePersonDetailsHistoryUseCase createPersonDetailsHistoryUseCase, AddNewPersonDetailUseCase addNewPersonDetailUseCase) {
        this.createPersonDetailsHistoryUseCase = createPersonDetailsHistoryUseCase;
        this.addNewPersonDetailUseCase = addNewPersonDetailUseCase;
    }

    @Override
    public void createPersonDetailsHistoryByUserId(CreatePersonDetailsHistory createPersonDetailsHistory) {
        createPersonDetailsHistoryUseCase.execute(createPersonDetailsHistory);
    }

    @Override
    public NewPersonDetail addNewPersonDetail(UUID userId, CreateNewPersonDetail createNewPersonDetail) {
        addNewPersonDetailUseCase.execute(userId, createNewPersonDetail);
        return null;
    }

}
