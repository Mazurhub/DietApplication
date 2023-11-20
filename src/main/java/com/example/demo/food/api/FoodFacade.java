package com.example.demo.food.api;

import com.example.demo.food.api.dto.CreateFood;
import com.example.demo.food.api.dto.Food;

import java.util.UUID;

public interface FoodFacade {
    Food createFood(CreateFood createFood);
    Food getFoodById(UUID foodId);
}
