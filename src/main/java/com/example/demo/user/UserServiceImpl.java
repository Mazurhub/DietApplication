package com.example.demo.user;

import com.example.demo.person.CreatePerson;
import com.example.demo.person.Person;
import com.example.demo.person.PersonEntity;
import com.example.demo.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    //TODO Create method to login by password and userName

    @Override
    public User createUser(CreateUser createUser) {
        UserEntity userEntity = mapToUserEntity(createUser);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        CreatePerson createPerson = new CreatePerson();
        createPerson.setEmail(createUser.getEmail());
        createPerson.setPhoneNumber(createUser.getPhoneNumber());
        PersonEntity personEntity = mapToPersonEntity(createPerson);
        personEntity.setUserEntity(savedUserEntity);
        return mapToUser(savedUserEntity);
    }

    @Override
    public User getUser(UUID id) {
        UserEntity userEntity = userRepository.findById(id).get();
        return mapToUser(userEntity);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToUser)
                .toList();
    }

    @Override
    public User updateUser(UUID id, UpdateUser updatePerson) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setUserName(updatePerson.getUserName());
            existingUser.setPassword(updatePerson.getPassword());
            existingUser.setEmail(updatePerson.getEmail());
            existingUser.setPhoneNumber(updatePerson.getPhoneNumber());

            PersonEntity existingPerson = existingUser.getPersonEntity();
            if (existingPerson != null) {
                existingPerson.setEmail(updatePerson.getEmail());
                existingPerson.setPhoneNumber(updatePerson.getPhoneNumber());
                personRepository.save(existingPerson);
            }
            existingUser = userRepository.save(existingUser);
            return mapToUser(existingUser);
        }
        return null;
    }
    @Override
    public long deleteUser(UUID id) {
        userRepository.deleteById(id);
        return userRepository.count();
    }

    private UserEntity mapToUserEntity(CreateUser createUser) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID());
        userEntity.setUserName(createUser.getUserName());
        userEntity.setPassword(createUser.getPassword());
        userEntity.setEmail(createUser.getEmail());
        userEntity.setPhoneNumber(createUser.getPhoneNumber());
        return userEntity;
    }

    private User mapToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        user.setEmail(userEntity.getEmail());
        user.setPhoneNumber(userEntity.getPhoneNumber());
        return user;
    }

    private PersonEntity mapToPersonEntity(CreatePerson createPerson) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setEmail(createPerson.getEmail());
        personEntity.setPhoneNumber(createPerson.getPhoneNumber());
        return personEntity;
    }
}
