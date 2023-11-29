package com.example.demo.meal;

import com.example.demo.food.api.FoodFacade;
import com.example.demo.food.api.dto.Food;
import com.example.demo.meal.api.dto.CreateMeal;
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
                .map(foodFacade::getFoodById)
                .toList();

        MealEntity mealEntity = new MealEntity();
        mealEntity.setId(UUID.randomUUID());
        mealEntity.setName(createMeal.name());
        mealEntity.setFoodIds(foods.stream().map(Food::id).collect(Collectors.toList()));

        mealEntity.setTotalKcal(foods.stream().mapToDouble(Food::kcal).sum());
        mealEntity.setTotalProtein(foods.stream().mapToDouble(Food::protein).sum());
        mealEntity.setTotalFat(foods.stream().mapToDouble(Food::fat).sum());
        mealEntity.setTotalCarbs(foods.stream().mapToDouble(Food::carbs).sum());

        MealEntity savedMealEntity = mealRepository.save(mealEntity);
        return savedMealEntity.getId();
    }
}
