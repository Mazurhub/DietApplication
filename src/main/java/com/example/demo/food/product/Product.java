package com.example.demo.food.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private double productWeight;
    private double kcal;
    private double proteins;
    private double fats;
    private double carbs;
}
