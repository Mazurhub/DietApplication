package com.example.demo.person_measurement.api;

import com.example.demo.person_measurement.api.dto.CreatePersonData;
import com.example.demo.person_measurement.api.dto.PersonData;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/person_data")
class PersonDataController {

    private final PersonDataFacade personDataFacade;

    PersonDataController(PersonDataFacade personDataFacade) {
        this.personDataFacade = personDataFacade;
    }

    @PostMapping
    PersonData createPersonData (@RequestBody CreatePersonData createPersonData){
        return personDataFacade.createPersonDataByUserId(createPersonData);
    }
    @RequestMapping("/{userId}")
    @GetMapping
    PersonData getPersonData(@PathVariable UUID userId){
        return personDataFacade.getPersonDataByUserId(userId);
    }
}