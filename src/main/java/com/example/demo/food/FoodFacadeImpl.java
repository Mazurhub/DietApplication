package com.example.demo.food;

import com.example.demo.food.api.FoodFacade;
import com.example.demo.food.api.dto.CreateFood;
import com.example.demo.food.api.dto.Food;
import com.example.demo.food.api.dto.UpdateFood;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
class FoodFacadeImpl implements FoodFacade {
    private final CreateFoodUseCase createFoodUseCase;
    private final GetFoodUseCase getFoodUseCase;
    private final GetFoodsUseCase getFoodsUseCase;
    private final UpdateFoodUseCase updateFoodUseCase;

    FoodFacadeImpl(CreateFoodUseCase createFoodUseCase, GetFoodUseCase getFoodUseCase, GetFoodsUseCase getFoodsUseCase, UpdateFoodUseCase updateFoodUseCase) {
        this.createFoodUseCase = createFoodUseCase;
        this.getFoodUseCase = getFoodUseCase;
        this.getFoodsUseCase = getFoodsUseCase;
        this.updateFoodUseCase = updateFoodUseCase;
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

    @Override
    public List<Food> getFoods() {
        return getFoodsUseCase.execute();
    }

    @Override
    public Food updateFood(UUID foodId, UpdateFood updateFood) {
        updateFoodUseCase.execute(foodId,updateFood);
        return getFoodUseCase.execute(foodId);
    }
}
