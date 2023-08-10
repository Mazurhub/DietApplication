package com.example.demo.food.xmeal;

import com.example.demo.food.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private double totalKcal;
    private double totalProteins;
    private double totalFats;
    private double totalCarbs;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "meal_entity_products",
            joinColumns = @JoinColumn(name = "meal_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<ProductEntity> products = new ArrayList<>(); // Inicjalizacja listy w konstruktorze

    public void addProduct(ProductEntity product) {
        products.add(product);
    }
}
