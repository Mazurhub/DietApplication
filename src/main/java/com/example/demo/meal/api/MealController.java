package com.example.demo.meal.api;

import com.example.demo.food.api.FoodFacade;
import com.example.demo.meal.api.dto.CreateMeal;
import com.example.demo.meal.api.dto.Meal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/meal")
class MealController {

    private final MealFacade mealFacade;
    private final FoodFacade foodFacade;

    MealController(MealFacade mealFacade, FoodFacade foodFacade) {
        this.mealFacade = mealFacade;
        this.foodFacade = foodFacade;
    }

    @PostMapping
    Meal createMeal(@RequestBody CreateMeal createMeal) {
        return mealFacade.createMeal(createMeal);
    }

    @RequestMapping("/{mealId}")
    @GetMapping
    Meal getMeal(@PathVariable UUID mealId) {
        return mealFacade.getMealById(mealId);
    }
}
