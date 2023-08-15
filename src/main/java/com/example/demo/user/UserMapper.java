package com.example.demo.user;
import com.example.demo.user.api.dto.User;


public class UserMapper {
    static User mapToDTO(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getPhoneNumber()
        );
    }
}

