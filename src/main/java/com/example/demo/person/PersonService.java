package com.example.demo.person;

import com.example.demo.persondetails.CreatePersonDetails;
import com.example.demo.persondetails.PersonDetails;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PersonService {
    Person createPerson(CreatePerson createPerson);

    PersonDetails addPersonDetails(UUID id, CreatePersonDetails createPersonDetails);

    Person getPerson(UUID id);

    List<Person> getPersons();

    Person updatePerson(UUID id, UpdatePerson updatePerson);

    Person updatePersonFields(UUID id, Map<String, Object> fields);

    long deletePerson(UUID id);

}
