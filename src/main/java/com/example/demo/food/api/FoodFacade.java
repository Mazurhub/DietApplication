package com.example.demo.food.api;

import com.example.demo.food.api.dto.CreateFood;
import com.example.demo.food.api.dto.Food;
import com.example.demo.food.api.dto.UpdateFood;

import java.util.List;
import java.util.UUID;

public interface FoodFacade {
    Food createFood(CreateFood createFood);

    Food getFoodById(UUID foodId);

    List<Food> getFoods();

    Food updateFood(UUID foodId, UpdateFood updateFood);

    long deleteFood(UUID foodId);
}
