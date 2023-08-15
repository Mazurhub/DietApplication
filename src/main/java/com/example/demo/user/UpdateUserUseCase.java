package com.example.demo.user;

import com.example.demo.user.api.dto.UpdateUser;
import com.example.demo.user.api.dto.User;
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
    User execute(UUID id, UpdateUser updateUser){
        UserEntity existingUser = userRepository.findById(id).get();
        existingUser.setUserName(updateUser.userName());
        existingUser.setPassword(updateUser.password());
        existingUser.setEmail(updateUser.email());
        existingUser.setPhoneNumber(updateUser.phoneNumber());

        existingUser = userRepository.save(existingUser);
        return new User(existingUser.getId(), updateUser.userName(), updateUser.password(), updateUser.email(), updateUser.phoneNumber());

    }
}
