package com.example.demo.person_measurement.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person_health_metric")
class PersonHealthMetricController {
    private final PersonHealthMetricFacade personHealthMetricFacade;

    PersonHealthMetricController(PersonHealthMetricFacade personHealthMetricFacade){
        this.personHealthMetricFacade = personHealthMetricFacade;
    }
}
