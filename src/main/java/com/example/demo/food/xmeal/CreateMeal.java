package com.example.demo.food.xmeal;

import com.example.demo.food.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMeal {

    private String name;
    private String category;
    private List<Product> products;
    private double totalKcal;
    private double totalProteins;
    private double totalFats;
    private double totalCarbs;

    // Dodaj konstruktor, który oblicza sumę wartości kalorycznych, białka, tłuszczu i węglowodanów
    public CreateMeal(String name, String category, List<Product> products) {
        this.name = name;
        this.category = category;
        this.products = products;
        this.totalKcal = calculateTotalKcal();
        this.totalProteins = calculateTotalProteins();
        this.totalFats = calculateTotalFats();
        this.totalCarbs = calculateTotalCarbs();
    }

    // Metoda do obliczenia sumy wartości kalorycznych
    private double calculateTotalKcal() {
        return products.stream().mapToDouble(Product::getKcal).sum();
    }

    // Metoda do obliczenia sumy wartości białka
    private double calculateTotalProteins() {
        return products.stream().mapToDouble(Product::getProteins).sum();
    }

    // Metoda do obliczenia sumy wartości tłuszczu
    private double calculateTotalFats() {
        return products.stream().mapToDouble(Product::getFats).sum();
    }

    // Metoda do obliczenia sumy wartości węglowodanów
    private double calculateTotalCarbs() {
        return products.stream().mapToDouble(Product::getCarbs).sum();
    }
}