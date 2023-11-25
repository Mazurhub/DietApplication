package com.example.demo.meal.api;

import com.example.demo.meal.api.dto.CreateMeal;
import com.example.demo.meal.api.dto.Meal;

import java.util.UUID;

public interface MealFacade {

    Meal createMeal(CreateMeal createMeal);
    Meal getMealById(UUID mealId);
}
