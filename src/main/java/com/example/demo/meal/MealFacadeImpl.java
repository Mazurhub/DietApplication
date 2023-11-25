package com.example.demo.meal;

import com.example.demo.meal.api.MealFacade;
import com.example.demo.meal.api.dto.CreateMeal;
import com.example.demo.meal.api.dto.Meal;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
class MealFacadeImpl implements MealFacade {
    private final CreateMealUseCase createMealUseCase;
    private final GetMealUseCase getMealUseCase;

    MealFacadeImpl(CreateMealUseCase createMealUseCase, GetMealUseCase getMealUseCase) {
        this.createMealUseCase = createMealUseCase;
        this.getMealUseCase = getMealUseCase;
    }

    @Override
    public Meal createMeal(CreateMeal createMeal) {
        UUID mealId = createMealUseCase.execute(createMeal);
        return getMealById(mealId);
    }

    @Override
    public Meal getMealById(UUID mealId) {
        return getMealUseCase.execute(mealId);
    }
}
