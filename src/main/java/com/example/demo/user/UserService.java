package com.example.demo.user;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(CreateUser createUser);
    User getUser(UUID id);
    List<User> getUsers();
    User updateUser(UUID id, UpdateUser updatePerson);
    long deleteUser(UUID id);
}
