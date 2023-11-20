package com.example.demo.food;

import com.example.demo.food.api.dto.Food;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
class GetFoodUseCase {
    private final FoodRepository foodRepository;

    GetFoodUseCase(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    Food execute(UUID foodId) {
        FoodEntity foodEntity = foodRepository.findById(foodId).get();
        return new Food(
                foodEntity.getId(),
                foodEntity.getName(),
                foodEntity.getKcal(),
                foodEntity.getProtein(),
                foodEntity.getFat(),
                foodEntity.getCarbs()
        );
    }
}
