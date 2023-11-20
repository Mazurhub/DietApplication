package com.example.demo.food;

import com.example.demo.food.api.dto.Food;

class FoodMapper {
    static Food mapToDTO(FoodEntity foodEntity){
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
