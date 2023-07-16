package com.example.demo.person;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PersonService {
    Person createPerson(CreatePerson createPerson);

    Person getPerson(UUID id);

    List<Person> getPersons();

    Person updatePerson(UUID id, UpdatePerson updatePerson);

    Person updatePersonFields(UUID id, Map<String, Object> fields);

    long deletePerson(UUID id);

}
