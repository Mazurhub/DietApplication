package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.CreatePersonDetailsHistory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
class CreatePersonDetailsHistoryUseCase {

    private final PersonDetailsHistoryRepository personDetailsHistoryRepository;

    CreatePersonDetailsHistoryUseCase(PersonDetailsHistoryRepository personDetailsHistoryRepository) {
        this.personDetailsHistoryRepository = personDetailsHistoryRepository;
    }

    void execute(CreatePersonDetailsHistory createPersonDetailsHistory) {
        var personDetailsHistory = new PersonDetailsHistoryEntity();
        personDetailsHistory.setUserId(createPersonDetailsHistory.userId());
        personDetailsHistoryRepository.save(personDetailsHistory);

    }
}