package com.example.demo.persondetails;

import com.example.demo.person.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PersonDetailsService {
    PersonDetails createPersonDetails(CreatePersonDetails createPersonDetails);
    PersonDetails calculateBMI(UUID id);
    PersonDetails calculatePPM(UUID id);
    PersonDetails calculateCPM(UUID id);
    ResponseEntity<List<Double>> calculateMacroelements(UUID id);
    PersonDetails getPersonDetails(UUID id);


}
