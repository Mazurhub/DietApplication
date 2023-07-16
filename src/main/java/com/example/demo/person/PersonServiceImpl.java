package com.example.demo.person;

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

public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;

    @Override
    public Person createPerson(CreatePerson createPerson) {
        PersonEntity personEntity = mapToPersonEntity(createPerson);
        PersonEntity savedPersonEntity = repository.save(personEntity);
        return mapToPerson(savedPersonEntity);
    }

    @Override
    public Person getPerson(UUID id) {
        PersonEntity personEntity = repository.findById(id).get();
        return mapToPerson(personEntity);
    }

    @Override
    public List<Person> getPersons() {
        return repository.findAll().stream().map(this::mapToPerson).toList();
    }

    @Override
    public Person updatePerson(UUID id, UpdatePerson updatePerson) {
        PersonEntity existingPerson = repository.findById(id).get();
        existingPerson.setName(updatePerson.getName());
        existingPerson.setSurname(updatePerson.getSurname());
        return mapToPerson(repository.save(existingPerson));
    }

    @Override
    public Person updatePersonFields(UUID id, Map<String, Object> fields) {
        Optional<PersonEntity> existingPerson = repository.findById(id);

        if (existingPerson.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(PersonEntity.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingPerson.get(), value);
            });
            return mapToPerson(repository.save(existingPerson.get()));
        }
        return null;
    }

    @Override
    public long deletePerson(UUID id) {
        repository.deleteById(id);
        return repository.count();
    }

    private PersonEntity mapToPersonEntity(CreatePerson createPerson) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(UUID.randomUUID());
        personEntity.setName(createPerson.getName());
        personEntity.setSurname(createPerson.getSurname());
        return personEntity;
    }
    private Person mapToPerson(PersonEntity personEntity) {
        Person person = new Person();
        person.setId(personEntity.getId());
        person.setName(personEntity.getName());
        person.setSurname(personEntity.getSurname());
        return person;
    }
}
