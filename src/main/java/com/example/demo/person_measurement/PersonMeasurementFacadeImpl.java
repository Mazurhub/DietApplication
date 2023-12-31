package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.PersonMeasurementFacade;
import com.example.demo.person_measurement.api.dto.CreateNewPersonDetail;
import com.example.demo.person_measurement.api.dto.CreatePersonDetailsHistory;
import com.example.demo.person_measurement.api.dto.NewPersonDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
class PersonMeasurementFacadeImpl implements PersonMeasurementFacade {

    private final CreatePersonDetailsHistoryUseCase createPersonDetailsHistoryUseCase;
    private final AddNewPersonDetailUseCase addNewPersonDetailUseCase;
    private final GetPersonDetailsHistoryUseCase getPersonDetailsHistoryUseCase;
    private final GetCurrentPersonDetailByUserIdUseCase getCurrentPersonDetailByUserIdUseCase;

    PersonMeasurementFacadeImpl(CreatePersonDetailsHistoryUseCase createPersonDetailsHistoryUseCase, AddNewPersonDetailUseCase addNewPersonDetailUseCase, GetPersonDetailsHistoryUseCase getPersonDetailsHistoryUseCase, GetCurrentPersonDetailByUserIdUseCase getCurrentPersonDetailByUserIdUseCase) {
        this.createPersonDetailsHistoryUseCase = createPersonDetailsHistoryUseCase;
        this.addNewPersonDetailUseCase = addNewPersonDetailUseCase;
        this.getPersonDetailsHistoryUseCase = getPersonDetailsHistoryUseCase;
        this.getCurrentPersonDetailByUserIdUseCase = getCurrentPersonDetailByUserIdUseCase;
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

    @Override
    public List<NewPersonDetail> getPersonDetailsHistory(UUID userId) {
        return getPersonDetailsHistoryUseCase.execute(userId);
    }

    @Override
    public NewPersonDetail getCurrentPersonDetailByUserId(UUID userId) {
        return getCurrentPersonDetailByUserIdUseCase.execute(userId);
    }

}
