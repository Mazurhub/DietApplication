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
                .map(foodId -> foodFacade.getFoodById(foodId))
                .collect(Collectors.toList());

        MealEntity mealEntity = new MealEntity();
        mealEntity.setId(UUID.randomUUID());
        mealEntity.setName(createMeal.name());
        mealEntity.setFoodIds(foods.stream().map(Food::getId).collect(Collectors.toList()));

        mealEntity.setTotalKcal(foods.stream().mapToDouble(Food::getKcal).sum());
        mealEntity.setTotalProtein(foods.stream().mapToDouble(Food::getProtein).sum());
        mealEntity.setTotalFat(foods.stream().mapToDouble(Food::getFat).sum());
        mealEntity.setTotalCarbs(foods.stream().mapToDouble(Food::getCarbs).sum());

        MealEntity savedMealEntity = mealRepository.save(mealEntity);
        return savedMealEntity.getId();
    }
}
