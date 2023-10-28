package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.CreateNewPersonDetail;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@Transactional
class AddNewPersonDetailUseCase {

    private final PersonDetailsHistoryRepository personDetailsHistoryRepository;
    private final CalculatePersonHealthMetricUseCase calculatePersonHealthMetricUseCase;

    public AddNewPersonDetailUseCase(PersonDetailsHistoryRepository personDetailsHistoryRepository, CalculatePersonHealthMetricUseCase calculatePersonHealthMetricUseCase) {
        this.personDetailsHistoryRepository = personDetailsHistoryRepository;
        this.calculatePersonHealthMetricUseCase = calculatePersonHealthMetricUseCase;
    }

    void execute(UUID userId, CreateNewPersonDetail createNewPersonDetail) {
        Optional<PersonDetailsHistoryEntity> historyOptional = personDetailsHistoryRepository.findByUserId(userId);
        PersonDetailsHistoryEntity personDetailsHistory = historyOptional.get();

        PersonDetailEntity personDetailEntity = new PersonDetailEntity(
                createNewPersonDetail.weight(),
                createNewPersonDetail.height(),
                createNewPersonDetail.age(),
                createNewPersonDetail.sex(),
                createNewPersonDetail.palCoefficient(),
                createNewPersonDetail.measurementDate(),
                personDetailsHistory
        );

        calculatePersonHealthMetricUseCase.calculateMetrics(createNewPersonDetail, personDetailEntity);

        personDetailsHistory.getNewPersonDetail().add(personDetailEntity);
        personDetailsHistoryRepository.save(personDetailsHistory);
    }
}