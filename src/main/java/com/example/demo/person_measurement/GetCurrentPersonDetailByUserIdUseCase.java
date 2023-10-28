package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.NewPersonDetail;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class GetCurrentPersonDetailByUserIdUseCase {

    private final PersonDetailsHistoryRepository personDetailsHistoryRepository;
    private final NewPersonDetailRepository newPersonDetailRepository;

    public GetCurrentPersonDetailByUserIdUseCase(
            PersonDetailsHistoryRepository personDetailsHistoryRepository,
            NewPersonDetailRepository newPersonDetailRepository) {
        this.personDetailsHistoryRepository = personDetailsHistoryRepository;
        this.newPersonDetailRepository = newPersonDetailRepository;
    }

    NewPersonDetail execute(UUID userId) {
        Optional<PersonDetailEntity> latestDetailOptional = newPersonDetailRepository.findLatestByUserId(userId);
        return latestDetailOptional.map(NewPersonDetailMapper::mapToDTO).get();
        }
    }

