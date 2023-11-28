package com.example.demo.meal;

import com.example.demo.food.api.FoodFacade;
import com.example.demo.food.api.dto.Food;
import com.example.demo.meal.api.dto.CreateMeal;
import com.example.demo.meal.api.dto.Meal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
class CreateMealUseCase {
    private final MealRepository mealRepository;
    private final FoodFacade foodFacade;

    CreateMealUseCase(MealRepository mealRepository, FoodFacade foodFacade) {
        this.mealRepository = mealRepository;
        this.foodFacade = foodFacade;
    }

    UUID execute(CreateMeal createMeal) {
        List<Food> foods = createMeal.foodIds().stream()
                .map(foodId -> foodFacade.getFoodById(foodId))
                .collect(Collectors.toList());

        MealEntity mealEntity = new MealEntity();
        mealEntity.setId(UUID.randomUUID());
        mealEntity.setName(createMeal.name());
        mealEntity.setFoodList(foods);

        MealEntity savedMealEntity = mealRepository.save(mealEntity);
        return savedMealEntity.getId();
    }
}
