package com.example.demo.user;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteUserUseCase {
    private final UserRepository userRepository;

    DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Long execute (UUID id){
        userRepository.deleteById(id);
        return userRepository.count();
    }
}
