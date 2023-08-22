package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.NewPersonDetail;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
class GetPersonDetailsHistoryUseCase{

    private final PersonDetailsHistoryRepository personDetailsHistoryRepository;

    public GetPersonDetailsHistoryUseCase(PersonDetailsHistoryRepository personDetailsHistoryRepository) {
        this.personDetailsHistoryRepository = personDetailsHistoryRepository;
    }
    List<NewPersonDetail> execute(UUID userId) {
        Optional<PersonDetailsHistoryEntity> historyOptional = personDetailsHistoryRepository.findByUserId(userId);

        PersonDetailsHistoryEntity history = historyOptional.get();
        List<NewPersonDetailEntity> entityList = history.getNewPersonDetail();

        return entityList.stream()
                    .map(NewPersonDetailMapper::mapToDTO)
                    .collect(Collectors.toList());
    }
}