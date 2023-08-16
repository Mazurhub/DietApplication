package com.example.demo.user;

import com.example.demo.user.api.dto.UpdateUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Component
public class UpdateUserUseCase {
    private final UserRepository userRepository;

    UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UUID execute(UUID id, UpdateUser updateUser) {
        UserEntity existingUser = userRepository.findById(id).get();
        if (updateUser.userName() != null) {
            existingUser.setUserName(updateUser.userName());
        }
        if (updateUser.firstName() != null) {
            existingUser.setFirstName(updateUser.firstName());
        }
        if (updateUser.lastName() != null) {
            existingUser.setLastName(updateUser.lastName());
        }
        if (updateUser.password() != null) {
            existingUser.setPassword(updateUser.password());
        }
        if (updateUser.email() != null) {
            existingUser.setEmail(updateUser.email());
        }
        if (updateUser.phoneNumber() != null) {
            existingUser.setPhoneNumber(updateUser.phoneNumber());
        }
        existingUser = userRepository.save(existingUser);
        return existingUser.getUserId();

    }
}
