package com.example.demo.food.api.dto;

import java.util.UUID;

public record Food(UUID id, String name, double kcal, double protein, double fat, double carbs) {
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public double getKcal() {
        return kcal;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbs() {
        return carbs;
    }
}
