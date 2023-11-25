package com.example.demo.food.api;

import com.example.demo.food.api.dto.CreateFood;
import com.example.demo.food.api.dto.Food;
import com.example.demo.food.api.dto.UpdateFood;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/food")
class FoodController {
    private final FoodFacade foodFacade;

    FoodController(FoodFacade foodFacade) {
        this.foodFacade = foodFacade;
    }

    @PostMapping
    Food createFood(@RequestBody CreateFood createFood) {
        return foodFacade.createFood(createFood);
    }

    @RequestMapping("/{foodId}")
    @GetMapping
    Food getFood(@PathVariable UUID foodId) {
        return foodFacade.getFoodById(foodId);
    }

    @GetMapping
    List<Food> getFoods() {
        return foodFacade.getFoods();
    }
    @PutMapping("/{foodId}")
    Food updateFood(@PathVariable UUID foodId, @RequestBody UpdateFood updateFood) {
        return foodFacade.updateFood(foodId, updateFood);
    }
    @DeleteMapping("/{foodId}")
    long deleteFood(@PathVariable UUID foodId){
        return foodFacade.deleteFood(foodId);
    }
}
