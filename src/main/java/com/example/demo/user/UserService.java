package com.example.demo.user;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserService {
    User createUser(CreateUser createUser);
    User getUser(UUID id);
    List<User> getUsers();
    User updateUser(UUID id, UpdateUser updatePerson);
    User updateUserFields(UUID id, Map<String, Object> fields);
    long deleteUser(UUID id);
}
