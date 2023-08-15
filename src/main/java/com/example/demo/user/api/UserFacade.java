package com.example.demo.user.api;

import com.example.demo.user.api.dto.CreateUser;
import com.example.demo.user.api.dto.UpdateUser;
import com.example.demo.user.api.dto.User;

import java.util.List;
import java.util.UUID;

public interface UserFacade {
    User createUser(CreateUser createUser);

    User getUserById(UUID id);

    List<User> getUsers();

    User updateUser(UUID id, UpdateUser updateUser);

    long deleteUser(UUID id);
}
