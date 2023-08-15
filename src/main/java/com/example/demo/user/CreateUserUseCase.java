package com.example.demo.user;

import com.example.demo.user.api.dto.CreateUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Component
public class CreateUserUseCase {
    private final UserRepository userRepository;

    CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UUID execute(CreateUser createUser) {
        var savedUserEntity = new UserEntity();
        savedUserEntity.setId(UUID.randomUUID());
        savedUserEntity.setUserName(createUser.userName());
        savedUserEntity.setFirstName(createUser.firstName());
        savedUserEntity.setLastName(createUser.lastName());
        savedUserEntity.setPassword(createUser.password());
        savedUserEntity.setEmail(createUser.email());
        savedUserEntity.setPhoneNumber(createUser.phoneNumber());

        var userEntity = userRepository.save(savedUserEntity);
        return userEntity.getId();
    }


}


