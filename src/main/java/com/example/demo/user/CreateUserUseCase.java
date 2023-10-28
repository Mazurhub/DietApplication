package com.example.demo.user;

import com.example.demo.person_measurement.api.PersonMeasurementFacade;
import com.example.demo.person_measurement.api.dto.CreatePersonDetailsHistory;
import com.example.demo.user.api.dto.CreateUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Component
class CreateUserUseCase {
    private final UserRepository userRepository;
    private final PersonMeasurementFacade personMeasurementFacade;

    CreateUserUseCase(UserRepository userRepository, PersonMeasurementFacade personMeasurementFacade) {
        this.userRepository = userRepository;
        this.personMeasurementFacade = personMeasurementFacade;
    }

    UUID execute(CreateUser createUser) {
        var savedUserEntity = new UserEntity();
        savedUserEntity.setUserId(UUID.randomUUID());
        savedUserEntity.setUserName(createUser.userName());
        savedUserEntity.setFirstName(createUser.firstName());
        savedUserEntity.setLastName(createUser.lastName());
        savedUserEntity.setPassword(createUser.password());
        savedUserEntity.setEmail(createUser.email());
        savedUserEntity.setPhoneNumber(createUser.phoneNumber());

        var userEntity = userRepository.save(savedUserEntity);
        personMeasurementFacade.createPersonDetailsHistoryByUserId(
                new CreatePersonDetailsHistory(
                        userEntity.getUserId()));
        return userEntity.getUserId();
    }
}


