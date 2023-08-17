package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.PersonData;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Component
class GetPersonDataByUserIdUseCase {

    private final PersonDataRepository personDataRepository;

    GetPersonDataByUserIdUseCase(PersonDataRepository personDataRepository) {
        this.personDataRepository = personDataRepository;
    }

    PersonData execute(UUID userId) {
        var personDataEntity = personDataRepository.findById(userId).get();
        return new PersonData(
                personDataEntity.getWeight(),
                personDataEntity.getHeight(),
                personDataEntity.getAge(),
                personDataEntity.getSex(),
                personDataEntity.getPalCoefficient());
    }
}
