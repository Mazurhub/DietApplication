package com.example.demo.meal.api.dto;

import java.util.List;
import java.util.UUID;

public record Meal(UUID mealId, String name, List<UUID> foodList) {
}
