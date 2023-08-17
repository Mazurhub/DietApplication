package com.example.demo.user;

import com.example.demo.user.api.dto.User;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
class GetUserUseCase {

    private final UserRepository userRepository;

    GetUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    User execute (UUID userId){
        var userEntity = userRepository.findById(userId).get();
        return new User(
                userEntity.getUserId(),
                userEntity.getUserName(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getPhoneNumber());
    }
}
