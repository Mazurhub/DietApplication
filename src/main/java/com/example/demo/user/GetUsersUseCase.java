package com.example.demo.user;

import com.example.demo.user.api.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class GetUsersUseCase {
    private final UserRepository userRepository;

    GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> execute() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToDTO)
                .toList();
    }
}