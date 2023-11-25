package com.example.demo.meal.api.dto;

import java.util.UUID;

public record UpdateMeal(UUID mealId, String name, double kcal, double protein, double fat, double carbs) {
}
