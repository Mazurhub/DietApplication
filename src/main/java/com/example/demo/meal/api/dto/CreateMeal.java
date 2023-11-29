package com.example.demo.meal.api.dto;

import java.util.List;
import java.util.UUID;

public record CreateMeal(String name, List<UUID> foodIds, List<Double> amounts) {
}