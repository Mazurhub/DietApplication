package com.example.demo.meal.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal")
class MealController {

    private final MealFacade mealFacade;

    MealController(MealFacade mealFacade) {
        this.mealFacade = mealFacade;
    }
}
