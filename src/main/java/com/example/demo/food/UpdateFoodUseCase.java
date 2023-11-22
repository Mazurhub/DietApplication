package com.example.demo.food;

import com.example.demo.food.api.dto.UpdateFood;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class UpdateFoodUseCase {
    private final FoodRepository foodRepository;

    UpdateFoodUseCase(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    UUID execute(UUID foodId, UpdateFood updateFood) {
        FoodEntity existingFood = foodRepository.findById(foodId).get();
        if (updateFood.name() != null) {
            existingFood.setName(updateFood.name());
        }
        if (updateFood.kcal() != 0) {
            existingFood.setKcal(updateFood.kcal());
        }
        if (updateFood.protein() != 0) {
            existingFood.setProtein(updateFood.protein());
        }
        if (updateFood.fat() != 0) {
            existingFood.setFat(updateFood.fat());
        }
        if (updateFood.carbs() != 0) {
            existingFood.setCarbs(updateFood.carbs());
        }
        existingFood = foodRepository.save(existingFood);
        return existingFood.getId();

    }
}