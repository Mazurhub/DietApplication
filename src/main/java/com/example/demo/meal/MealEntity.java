package com.example.demo.meal;


import com.example.demo.food.api.dto.Food;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
class MealEntity {
    @Id
    private UUID id;
    private String name;

    @ElementCollection
    private List<UUID> foodIds;

    public void setFoodList(List<Food> foodList) {
        this.foodIds = foodList.stream()
                .map(Food::getId)
                .collect(Collectors.toList());
    }
}