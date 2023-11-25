package com.example.demo.meal;

import com.example.demo.food.api.FoodFacade;
import com.example.demo.meal.api.dto.CreateMeal;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Component
class CreateMealUseCase {
    private final MealRepository mealRepository;
    private final FoodFacade foodFacade;

    CreateMealUseCase(MealRepository mealRepository, FoodFacade foodFacade) {
        this.mealRepository = mealRepository;
        this.foodFacade = foodFacade;
    }
    UUID execute(CreateMeal createMeal){
        MealEntity savedMealEntity = new MealEntity();
        savedMealEntity.setId(UUID.randomUUID());
        savedMealEntity.setName(createMeal.name());
        savedMealEntity.setKcal(createMeal.kcal());
        savedMealEntity.setProtein(createMeal.protein());
        savedMealEntity.setFat(createMeal.fat());
        savedMealEntity.setCarbs(createMeal.carbs());

        MealEntity mealEntity = mealRepository.save(savedMealEntity);
        return mealEntity.getId();
    }
}
