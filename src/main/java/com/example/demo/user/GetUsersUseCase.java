package com.example.demo.user;

import com.example.demo.user.api.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUsersUseCase {
    private final UserRepository userRepository;

    GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> execute() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToUser)
                .toList();
    }
    private User mapToUser(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUserName(), userEntity.getPassword(), userEntity.getEmail(), userEntity.getPhoneNumber());
    }
}