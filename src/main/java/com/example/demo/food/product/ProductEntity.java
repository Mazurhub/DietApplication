package com.example.demo.food.product;

import com.example.demo.food.xmeal.MealEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double productWeight;
    private double kcal;
    private double proteins;
    private double fats;
    private double carbs;

    @ManyToMany(mappedBy = "products")
    private List<MealEntity> meals;

    public ProductEntity(String name, double kcal, double productWeight, double proteins, double fats, double carbs) {
        this.name = name;
        this.productWeight = productWeight;
        this.kcal = kcal;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }
}

