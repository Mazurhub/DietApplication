package com.example.demo.food;

import com.example.demo.food.api.FoodFacade;
import com.example.demo.food.api.dto.CreateFood;
import com.example.demo.food.api.dto.Food;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class FoodFacadeImpl implements FoodFacade {
    private final CreateFoodUseCase createFoodUseCase;
    private final GetFoodUseCase getFoodUseCase;

    FoodFacadeImpl(CreateFoodUseCase createFoodUseCase, GetFoodUseCase getFoodUseCase) {
        this.createFoodUseCase = createFoodUseCase;
        this.getFoodUseCase = getFoodUseCase;
    }
    @Override
    public Food createFood(CreateFood createFood){
        UUID foodId = createFoodUseCase.execute(createFood);
        return getFoodById(foodId);
    }
    @Override
    public Food getFoodById(UUID foodId){
        return getFoodUseCase.execute(foodId);
    }
}
