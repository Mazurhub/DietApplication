package com.example.demo.food.api;

import com.example.demo.food.api.dto.CreateFood;
import com.example.demo.food.api.dto.Food;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
class FoodController {
    private final FoodFacade foodFacade;

    FoodController(FoodFacade foodFacade) {
        this.foodFacade = foodFacade;
    }
    @PostMapping
    Food createFood(@RequestBody CreateFood createFood){
        return foodFacade.createFood(createFood);
    }
}
