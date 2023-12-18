package com.example.demo.meal;

import com.example.demo.food.api.FoodFacade;
import com.example.demo.food.api.dto.Food;
import com.example.demo.meal.api.dto.CreateMeal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CreateMealUseCase {
    private final MealRepository mealRepository;
    private final FoodFacade foodFacade;
    private final NutritionCalculator nutritionCalculator;

    CreateMealUseCase(MealRepository mealRepository, FoodFacade foodFacade, NutritionCalculator nutritionCalculator) {
        this.mealRepository = mealRepository;
        this.foodFacade = foodFacade;
        this.nutritionCalculator = nutritionCalculator;
    }

    UUID execute(CreateMeal createMeal) {
        List<Food> foods = IntStream.range(0, createMeal.foodIds().size())
                .mapToObj(i -> calculateFoodWithNutrition(i, createMeal))
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

    private Food calculateFoodWithNutrition(int index, CreateMeal createMeal) {
        UUID foodId = createMeal.foodIds().get(index);
        double newAmount = createMeal.amounts().get(index);
        Food oldAmount = foodFacade.getFoodById(foodId);
        return nutritionCalculator.calculateNutrition(oldAmount, newAmount);
    }
}

