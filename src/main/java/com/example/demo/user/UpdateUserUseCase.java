package com.example.demo.user;

import com.example.demo.user.api.dto.UpdateUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Transactional
@Component
public class UpdateUserUseCase {
    private final UserRepository userRepository;

    UpdateUserUseCase (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    UUID execute(UUID id, UpdateUser updateUser){
        UserEntity existingUser = userRepository.findById(id).get();
        existingUser.setUserName(updateUser.userName());
        existingUser.setPassword(updateUser.password());
        existingUser.setEmail(updateUser.email());
        existingUser.setPhoneNumber(updateUser.phoneNumber());

        existingUser = userRepository.save(existingUser);
        return existingUser.getId();

    }
}
