package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.CreatePersonData;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Component
class CreatePersonDataUseCase {

    private final PersonDataRepository personDataRepository;

    CreatePersonDataUseCase(PersonDataRepository personDataRepository) {
        this.personDataRepository = personDataRepository;
        }
    UUID execute(CreatePersonData createPersonData){
        var personDataSaved = new PersonDataEntity();
        personDataSaved.setPersonDataId(createPersonData.userId());
        personDataSaved.setWeight(createPersonData.weight());
        personDataSaved.setHeight(createPersonData.height());
        personDataSaved.setAge(createPersonData.age());
        personDataSaved.setSex(createPersonData.sex());
        personDataSaved.setPalCoefficient(createPersonData.palCoefficient());

        var personDataEntity = personDataRepository.save(personDataSaved);
        return personDataEntity.getPersonDataId();


    }
}
