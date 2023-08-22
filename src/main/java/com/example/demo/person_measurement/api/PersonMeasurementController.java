package com.example.demo.person_measurement.api;

import com.example.demo.person_measurement.NewPersonDetailEntity;
import com.example.demo.person_measurement.api.dto.CreateNewPersonDetail;
import com.example.demo.person_measurement.api.dto.NewPersonDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person_data")
class PersonMeasurementController {

    private final PersonMeasurementFacade personMeasurementFacade;


    PersonMeasurementController(PersonMeasurementFacade personMeasurementFacade) {
        this.personMeasurementFacade = personMeasurementFacade;
    }

    @PostMapping("/{userId}")
    ApiResponse addMeasurement(@PathVariable UUID userId, @RequestBody CreateNewPersonDetail createNewPersonDetail) {
        NewPersonDetail newPersonDetail = personMeasurementFacade.addNewPersonDetail(userId, createNewPersonDetail);
        return new ApiResponse("success", "Successfully added new values");
    }
    @GetMapping("/{userId}")
    List<NewPersonDetail> getMeasurementsByUserId(@PathVariable UUID userId) {
        return personMeasurementFacade.getPersonDetailsHistory(userId);
    }
    @GetMapping("/current/{userId}")
    public NewPersonDetail getCurrentPersonDetail(@PathVariable UUID userId) {
        return personMeasurementFacade.getCurrentPersonDetailByUserId(userId);
    }
}