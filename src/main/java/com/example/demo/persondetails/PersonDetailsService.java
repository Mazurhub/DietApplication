package com.example.demo.persondetails;

import java.util.UUID;

public interface PersonDetailsService {
    PersonDetails createPersonDetails(CreatePersonDetails createPersonDetails);
    PersonDetails calculateBMI(UUID id);
    PersonDetails calculatePPM(UUID id);
    PersonDetails calculateCPM(UUID id);
    PersonDetails getPersonDetails(UUID id);


}
