package com.example.demo.user;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class DeleteUserUseCase {
    private final UserRepository userRepository;

    DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Long execute (UUID userId){
        userRepository.deleteById(userId);
        return userRepository.count();
    }
}
