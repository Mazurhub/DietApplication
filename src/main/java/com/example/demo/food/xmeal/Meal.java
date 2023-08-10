package com.example.demo.food.xmeal;

import com.example.demo.food.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    private String name;
    private String category;
    private List<Product> products;
    private double totalKcal;
    private double totalProteins;
    private double totalFats;
    private double totalCarbs;
}