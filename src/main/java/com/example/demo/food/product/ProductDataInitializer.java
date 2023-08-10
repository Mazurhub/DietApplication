package com.example.demo.food.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataInitializer implements CommandLineRunner {

    private final ProductService productService;

    public ProductDataInitializer(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        // Dodaj tutaj produkty, które chcesz automatycznie dodać do bazy danych przy starcie aplikacji
        CreateProduct kotletSchabowy = new CreateProduct("Kotlet_Schabowy", 100.0, 353.0, 19.0, 15.5, 24.0);
        CreateProduct ziemniaki = new CreateProduct("Ziemniaki", 100.0, 80.0, 2.0, 16.8, 0.1);
        CreateProduct ogorki = new CreateProduct("Ogórki", 100.0, 16.0, 0.7, 3.1, 0.1);
        CreateProduct smietana = new CreateProduct("Śmietana", 100.0, 186.0, 2.5, 18.0, 3.6);

        productService.createProduct(kotletSchabowy);
        productService.createProduct(ziemniaki);
        productService.createProduct(ogorki);
        productService.createProduct(smietana);
    }
}
