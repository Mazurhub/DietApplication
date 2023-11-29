package com.example.demo.meal;

import com.example.demo.food.api.dto.Food;
import org.springframework.stereotype.Component;

@Component
class NutritionCalculator {

    Food calculateNutrition(Food food, double amount) {
        double factor = amount / 100.0;
        double kcal = food.kcal() * factor;
        double protein = food.protein() * factor;
        double fat = food.fat() * factor;
        double carbs = food.carbs() * factor;

        return new Food(food.id(), food.name(), kcal, protein, fat, carbs, amount);
    }
}
