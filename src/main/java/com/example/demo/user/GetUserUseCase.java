package com.example.demo.user;

import com.example.demo.user.api.dto.User;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class GetUserUseCase {

    private final UserRepository userRepository;

    GetUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    User execute (UUID id){
        var userEntity = userRepository.findById(id).get();
        return new User(userEntity.getId(), userEntity.getUserName(), userEntity.getPassword(), userEntity.getEmail(), userEntity.getPhoneNumber());
    }
}
