package com.example.demo.user;

import com.example.demo.person.CreatePerson;
import com.example.demo.person.Person;
import com.example.demo.person.PersonEntity;
import com.example.demo.person.PersonRepository;
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
    private final PersonRepository personRepository;

    @Override
    public User createUser(CreateUser createUser) {
        // Tworzymy nowego użytkownika
        UserEntity userEntity = mapToUserEntity(createUser);
        UserEntity savedUserEntity = repository.save(userEntity);

        // Tworzymy nowy obiekt PersonDetails, który zawiera informacje o użytkowniku
        CreatePerson createPerson = new CreatePerson();
        createPerson.setEmail(createUser.getEmail());
        createPerson.setPhoneNumber(createUser.getPhoneNumber());

        // Tworzymy osobę i przypisujemy ją do użytkownika
        PersonEntity personEntity = mapToPersonEntity(createPerson);
        personEntity.setUserEntity(savedUserEntity);
        PersonEntity savedPersonEntity = personRepository.save(personEntity);

        // Zwracamy użytkownika
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
        UserEntity existingUser = repository.findById(id).orElse(null);

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
            existingUser = repository.save(existingUser);
            return mapToUser(existingUser);
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
        personEntity.setId(UUID.randomUUID());
        personEntity.setName(createPerson.getName());
        personEntity.setSurname(createPerson.getSurname());
        personEntity.setEmail(createPerson.getEmail());
        personEntity.setPhoneNumber(createPerson.getPhoneNumber());
        return personEntity;
    }

    private Person mapToPerson(PersonEntity personEntity) {
        Person person = new Person();
        person.setId(personEntity.getId());
        person.setName(personEntity.getName());
        person.setSurname(personEntity.getSurname());
        person.setEmail(personEntity.getEmail());
        person.setPhoneNumber(personEntity.getPhoneNumber());
        return person;
    }
}
