package com.example.demo.meal;

import com.example.demo.food.api.FoodFacade;
import com.example.demo.meal.api.dto.Meal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
class GetMealUseCase {
    private final MealRepository mealRepository;
    private final FoodFacade foodFacade;

    GetMealUseCase(MealRepository mealRepository, FoodFacade foodFacade) {
        this.mealRepository = mealRepository;
        this.foodFacade = foodFacade;
    }

    Meal execute(UUID mealId) {
        MealEntity mealEntity = mealRepository.findById(mealId).orElseThrow();

        List<String> foodNames = mealEntity.getFoodIds().stream()
                .map(foodId -> foodFacade.getFoodById(foodId).name())
                .collect(Collectors.toList());

        return new Meal(
                mealEntity.getId(),
                mealEntity.getName(),
                mealEntity.getTotalKcal(),
                mealEntity.getTotalProtein(),
                mealEntity.getTotalFat(),
                mealEntity.getTotalCarbs(),
                foodNames
        );
    }
}