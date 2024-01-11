package com.example.demo.meal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
class MealEntity {
    @Id
    private UUID id;
    private String name;
    private List<UUID> foodIds;
    private double totalKcal;
    private double totalProtein;
    private double totalFat;
    private double totalCarbs;
    tests
}