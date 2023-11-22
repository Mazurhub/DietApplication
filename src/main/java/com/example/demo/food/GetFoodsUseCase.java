package com.example.demo.food;

import com.example.demo.food.api.dto.Food;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class GetFoodsUseCase {
    private final FoodRepository foodRepository;

    GetFoodsUseCase(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    List<Food> execute() {
        return foodRepository.findAll()
                .stream()
                .map(FoodMapper::mapToDTO)
                .toList();
    }
}
