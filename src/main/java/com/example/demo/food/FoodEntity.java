package com.example.demo.food;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
class FoodEntity {
    @Id
    private UUID id;
    private String name;
    private double kcal;
    private double protein;
    private double fat;
    private double carbs;
    private double amount;
}
