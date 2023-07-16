package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User createUser(CreateUser createUser) {
        UserEntity userEntity = mapToUserEntity(createUser);
        UserEntity savedUserEntity = repository.save(userEntity);
        return mapToUser(savedUserEntity);
    }

    @Override
    public User getUser(UUID id) {
        UserEntity userEntity = repository.findById(id).get();
        return mapToUser(userEntity);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll()
                .stream()
                .map(this::mapToUser)
                .toList();
    }

    @Override
    public User updateUser(UUID id, UpdateUser updatePerson) {
        UserEntity existingUser = repository.findById(id).get();
        existingUser.setName(updatePerson.getName());
        existingUser.setSurname(updatePerson.getSurname());
        return mapToUser(repository.save(existingUser));
    }

    @Override
    public User updateUserFields(UUID id, Map<String, Object> fields) {
        Optional<UserEntity> existingUser = repository.findById(id);

        if (existingUser.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(UserEntity.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingUser.get(), value);
            });
            return mapToUser(repository.save(existingUser.get()));
        }
        return null;
    }

    @Override
    public long deleteUser(UUID id) {
        repository.deleteById(id);
        return repository.count();
    }

    private UserEntity mapToUserEntity(CreateUser createUser) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID());
        userEntity.setName(createUser.getName());
        userEntity.setSurname(createUser.getSurname());
        return userEntity;
    }

    private User mapToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setSurname(userEntity.getSurname());
        return user;
    }
}
