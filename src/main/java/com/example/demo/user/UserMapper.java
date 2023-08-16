package com.example.demo.user;
import com.example.demo.user.api.dto.User;


class UserMapper {
    static User mapToDTO(UserEntity userEntity) {
        return new User(
                userEntity.getUserId(),
                userEntity.getUserName(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getPhoneNumber()
        );
    }
}

