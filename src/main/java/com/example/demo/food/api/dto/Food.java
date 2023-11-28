package com.example.demo.food.api.dto;

import java.util.UUID;

public record Food(UUID id, String name, double kcal, double protein, double fat, double carbs) {
    public UUID getId() {
        return id;
    }
}
