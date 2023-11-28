package com.example.demo.meal;

import com.example.demo.meal.api.dto.Meal;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class GetMealUseCase {
    private final MealRepository mealRepository;

    GetMealUseCase(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    Meal execute(UUID mealId) {
        MealEntity mealEntity = mealRepository.findById(mealId).get();
        return new Meal(
                mealEntity.getId(),
                mealEntity.getName(),
                mealEntity.getFoodIds()
        );
    }
}
