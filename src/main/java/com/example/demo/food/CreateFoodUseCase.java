package com.example.demo.food;

import com.example.demo.food.api.dto.CreateFood;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Component
class CreateFoodUseCase {
    private final FoodRepository foodRepository;

    CreateFoodUseCase(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    UUID execute(CreateFood createFood){
        FoodEntity savedFoodEntity = new FoodEntity();
        savedFoodEntity.setId(UUID.randomUUID());
        savedFoodEntity.setName(createFood.name());
        savedFoodEntity.setKcal(createFood.kcal());
        savedFoodEntity.setProtein(createFood.protein());
        savedFoodEntity.setFat(createFood.fat());
        savedFoodEntity.setCarbs(createFood.carbs());
        savedFoodEntity.setAmount(createFood.amount());

        FoodEntity foodEntity = foodRepository.save(savedFoodEntity);
        return foodEntity.getId();
    }
}
