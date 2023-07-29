package com.example.demo.person;

import com.example.demo.persondetails.CreatePersonDetails;
import com.example.demo.persondetails.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;

    @PostMapping
    public Person createPerson(@RequestBody CreatePerson createPerson) {
        return service.createPerson(createPerson);
    }
    @PostMapping("/details/{id}")
    public PersonDetails addPersonDetails(@PathVariable UUID id, @RequestBody CreatePersonDetails createPersonDetails) {
        return service.addPersonDetails(id, createPersonDetails);
    }
    @GetMapping
    @RequestMapping("/{id}")
    public Person getPerson(@PathVariable UUID id) {
        return service.getPerson(id);
    }
    @GetMapping
    public List<Person> getPersons() {return service.getPersons();}
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable UUID id, @RequestBody UpdatePerson updatePerson){
        return service.updatePerson(id, updatePerson);
    }
    @PatchMapping("/{id}")
    public Person updatePersonFields(@PathVariable UUID id, @RequestBody  Map<String, Object> fields) {
        return service.updatePersonFields(id, fields);
    }
    @DeleteMapping("/{id}")
    public long deletePerson(@PathVariable UUID id) {
        return service.deletePerson(id);
    }
    }



