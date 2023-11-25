package com.example.demo.food;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class DeleteFoodUseCase {

    private final FoodRepository foodRepository;

    DeleteFoodUseCase(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    Long execute(UUID foodId) {
        foodRepository.deleteById(foodId);
        return foodRepository.count();
    }
}
